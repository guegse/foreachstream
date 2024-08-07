# ForeachStream
This is a Javac compiler plugin and a companion library which turns
Java streams calls into calls to library functions which use foreach loops
internally. This yields a speedup of up to 500% compared to stream operations.

## Usage
### Maven
Add this dependency:
```XML
<dependencies>
    <dependency>
        <groupId>io.github.guegse.foreachstream</groupId>
        <artifactId>plugin</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```
The maven compiler plugin must be configured to fork in order to pass the additional arguments to the compiler.
Some packages need to be exported to the unnamed module in order for the plugin to do alter the abstract syntax tree it 
receives from the compiler.
Add this configuration to your maven compile plugin:
```XML
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <compilerArgs>
                    <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED</arg>
                    <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED</arg>
                    <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED</arg>
                    <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED</arg>
                    <arg>--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED</arg>
                    <arg>--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED</arg>
                    <arg>--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED</arg>
                    <arg>--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED</arg>
                </compilerArgs>
                <fork>true</fork>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## How does it work
The companion library contains static methods like these:
```Java
public static <T0> List<T0> stream_filter_collect_toList(Collection<T0> input, Predicate<T0> arg0) {
    ArrayList<T0> result = new ArrayList<>();
    for (T0 t0 : input) {
        if (!arg0.test(t0)) {
            continue;
        }
        result.add(t0);
    }
    return result;
}
```
The compiler plugin scans for patterns of streams invocations from the type "java.util.stream.Stream" , for example:
```Java
return persons.stream().filter(person -> person.name().equals("John")).collect(Collectors.toList());
```
and - completely opaque to the user - transforms these to an invocation of the corresponding library method:
```Java
return ForeachStreamCollectToList.stream_filter_collect_toList(persons, person -> person.name().equals("John"));
```

## Limitations
* When adding the dependency to your build the plugin will automatically run for the project depending on it. There is no way to disable it.
* The plugin produces verbose output and there is no way to disable that.
* There is little to no test coverage. Consider this an early alpha. Use at your own risk.
* Only a limited stream opertion *depth* is supported. 
* Only a limited number of stream operations are supported. See the section "Stream operations support matrix" for details.

## Stream operations support matrix

### Terminal operations
| Operation                     | Supported |
|-------------------------------|-----------|
| toSet (Java 16)               |           |
| toList (Java 16)              |           |
| collect(Collectors.toList()   | yes       |
| collect(Collectors.toSet()    | yes       |
| collect                       |           |
| forEach                       | yes       |
| forEachOrdered                |           |
| toArray                       |           |
| reduce                        |           |
| anyMatch                      | yes       |
| allMatch                      | yes       |
| noneMatch                     | yes       |
| findFirst                     | yes       |
| findAny                       | yes       |
| min                           | yes       |
| max                           | yes       |
| average                       |           |
| sum                           | yes       |
| summaryStatistics             |           |

### Intermediary operations
| Operation        | Supported |
|------------------|-----------|
| filter           | yes       |
| map              | yes       |
| mapToInt         | yes       |
| mapToLong        | yes       |
| mapToDouble      | yes       |
| mapToObj         | yes       |
| flatMap          |           |
| flatMapToInt     |           |
| flatMapToLong    |           |
| flatMapToDouble  |           |
| mapMulti         |           |
| mapMultiToInt    |           |
| mapMultiToLong   |           |
| mapMultiToDouble |           |
| distinct         |           |
| sorted           |           |
| peek             |           |
| limit            |           |
| skip             |           |
| takeWhile        |           |
| dropWhile        |           |
|                  |           |

## Benchmarks
These are very simple benchmarks performed with no real-world scenarios and on small sample data. 
This means the streams on which the operations are performed are very short which could increase the relative
overhead imposed by the need to create the stream objects. So take these results with a grain of salt.
It is best to perform your own benchmarks with your own code to see if there is a measurable difference when using this library or not.

The numbers here represent milliseconds to perform these operations on small lists. Smaller numbers are better.

| Operation                  | JDK streams | With ForeachStream | reference implementation using foreach loops |
|----------------------------|-------------|--------------------|----------------------------------------------|
| stream_filter_toList       | 14570       | 2910               | 3916                                         |
| stream_map_filter_toList   | 22591       | 5563               | 4789                                         |
| stream_filter_toSet        | 18800       | 6980               | 6920                                         |
| stream_map_forEach         | 15975       | 8455               | 6340                                         |

### Interpretation
The ForeachStream stream operation implementations outperform the JDK streams operations by up to 500%.
The reference implementations using foreach loops (without lambdas) are still faster than the ForeachStreams implementations. 
