# Factorial-benchmarks
Some algorithms to calculate factorial with benchmarks

Inspired by and based on:
* https://habrahabr.ru/post/255813/
* https://habrahabr.ru/post/255761/

Uses [JML](http://openjdk.java.net/projects/code-tools/jmh/) to do the benchmarking. 

***How to run***

```
mvn clean install
java -jar target/benchmarks.jar
```

***Benchmark result:***

Intel(R) Core(TM)2 Duo CPU     P8600  @ 2.40GHz

```
Benchmark                                (n)  Mode  Cnt        Score       Error  Units
MyBenchmark.testFactShift                 10  avgt   20        0.455 ±     0.008  us/op
MyBenchmark.testFactShift                100  avgt   20        8.049 ±     0.350  us/op
MyBenchmark.testFactShift               1000  avgt   20      518.921 ±     6.504  us/op
MyBenchmark.testFactShift              10000  avgt   20    67668.330 ±  2790.546  us/op
MyBenchmark.testFactShift              50000  avgt   20  2036408.998 ± 69713.327  us/op
MyBenchmark.testFactShiftTree             10  avgt   20        0.425 ±     0.007  us/op
MyBenchmark.testFactShiftTree            100  avgt   20        6.793 ±     0.315  us/op
MyBenchmark.testFactShiftTree           1000  avgt   20      113.184 ±     4.826  us/op
MyBenchmark.testFactShiftTree          10000  avgt   20     4900.953 ±    50.575  us/op
MyBenchmark.testFactShiftTree          50000  avgt   20    74184.759 ±   338.565  us/op
MyBenchmark.testFactShiftTreeForkJoin     10  avgt   20       17.096 ±     2.125  us/op
MyBenchmark.testFactShiftTreeForkJoin    100  avgt   20       26.018 ±     0.947  us/op
MyBenchmark.testFactShiftTreeForkJoin   1000  avgt   20      148.221 ±    14.371  us/op
MyBenchmark.testFactShiftTreeForkJoin  10000  avgt   20     4070.271 ±   101.217  us/op
MyBenchmark.testFactShiftTreeForkJoin  50000  avgt   20    61906.265 ±  6348.420  us/op
MyBenchmark.testFactTree                  10  avgt   20        0.256 ±     0.006  us/op
MyBenchmark.testFactTree                 100  avgt   20        4.796 ±     0.023  us/op
MyBenchmark.testFactTree                1000  avgt   20       89.093 ±     1.888  us/op
MyBenchmark.testFactTree               10000  avgt   20     5256.260 ±    24.035  us/op
MyBenchmark.testFactTree               50000  avgt   20    80814.276 ±  1662.423  us/op
MyBenchmark.testFourBlocks                10  avgt   20        0.596 ±     0.020  us/op
MyBenchmark.testFourBlocks               100  avgt   20        7.389 ±     0.054  us/op
MyBenchmark.testFourBlocks              1000  avgt   20      220.170 ±     9.332  us/op
MyBenchmark.testFourBlocks             10000  avgt   20    23732.874 ±   587.253  us/op
MyBenchmark.testFourBlocks             50000  avgt   20   604617.590 ± 16935.473  us/op
MyBenchmark.testNaive                     10  avgt   20        0.431 ±     0.009  us/op
MyBenchmark.testNaive                    100  avgt   20        8.707 ±     0.073  us/op
MyBenchmark.testNaive                   1000  avgt   20      582.665 ±     4.016  us/op
MyBenchmark.testNaive                  10000  avgt   20    71488.714 ±   302.861  us/op
MyBenchmark.testNaive                  50000  avgt   20  2185448.852 ± 55155.377  us/op
MyBenchmark.testStreamed                  10  avgt   20        0.481 ±     0.011  us/op
MyBenchmark.testStreamed                 100  avgt   20        9.096 ±     0.377  us/op
MyBenchmark.testStreamed                1000  avgt   20      603.399 ±    26.494  us/op
MyBenchmark.testStreamed               10000  avgt   20    69546.260 ±  2495.295  us/op
MyBenchmark.testStreamed               50000  avgt   20  2034699.821 ± 51516.068  us/op
MyBenchmark.testStreamedParallel          10  avgt   20        4.165 ±     0.131  us/op
MyBenchmark.testStreamedParallel         100  avgt   20       15.012 ±     1.793  us/op
MyBenchmark.testStreamedParallel        1000  avgt   20      152.454 ±     2.113  us/op
MyBenchmark.testStreamedParallel       10000  avgt   20    13391.956 ±  1693.633  us/op
MyBenchmark.testStreamedParallel       50000  avgt   20   298984.321 ± 25689.383  us/op
MyBenchmark.testStreamedParallelShift     10  avgt   20        4.507 ±     0.188  us/op
MyBenchmark.testStreamedParallelShift    100  avgt   20       15.272 ±     0.594  us/op
MyBenchmark.testStreamedParallelShift   1000  avgt   20      143.560 ±    14.585  us/op
MyBenchmark.testStreamedParallelShift  10000  avgt   20    11418.348 ±   184.639  us/op
MyBenchmark.testStreamedParallelShift  50000  avgt   20   301986.118 ± 35801.010  us/op
MyBenchmark.testStreamedShift             10  avgt   20        0.574 ±     0.013  us/op
MyBenchmark.testStreamedShift            100  avgt   20        8.736 ±     0.508  us/op
MyBenchmark.testStreamedShift           1000  avgt   20      512.447 ±     2.588  us/op
MyBenchmark.testStreamedShift          10000  avgt   20    65010.984 ±  3181.843  us/op
MyBenchmark.testStreamedShift          50000  avgt   20  1882692.405 ± 11696.611  us/op
```

Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz

```
Benchmark                                (n)  Mode  Cnt       Score       Error  Units
MyBenchmark.testFactFactorization         10  avgt   20       0,250 ±     0,007  us/op
MyBenchmark.testFactFactorization        100  avgt   20       2,242 ±     0,074  us/op
MyBenchmark.testFactFactorization       1000  avgt   20      78,634 ±     2,613  us/op
MyBenchmark.testFactFactorization      10000  avgt   20    9201,430 ±   219,746  us/op
MyBenchmark.testFactFactorization      50000  avgt   20  280531,670 ±  7423,222  us/op
MyBenchmark.testFactShift                 10  avgt   20       0,244 ±     0,007  us/op
MyBenchmark.testFactShift                100  avgt   20       3,606 ±     0,114  us/op
MyBenchmark.testFactShift               1000  avgt   20     156,331 ±     6,954  us/op
MyBenchmark.testFactShift              10000  avgt   20   19168,038 ±   706,043  us/op
MyBenchmark.testFactShift              50000  avgt   20  522962,954 ± 16136,208  us/op
MyBenchmark.testFactShiftTree             10  avgt   20       0,262 ±     0,007  us/op
MyBenchmark.testFactShiftTree            100  avgt   20       3,870 ±     0,190  us/op
MyBenchmark.testFactShiftTree           1000  avgt   20      50,096 ±     2,552  us/op
MyBenchmark.testFactShiftTree          10000  avgt   20    1760,467 ±    83,710  us/op
MyBenchmark.testFactShiftTree          50000  avgt   20   24382,022 ±   537,654  us/op
MyBenchmark.testFactShiftTreeForkJoin     10  avgt   20      16,463 ±     0,160  us/op
MyBenchmark.testFactShiftTreeForkJoin    100  avgt   20      31,198 ±     0,162  us/op
MyBenchmark.testFactShiftTreeForkJoin   1000  avgt   20      65,820 ±     1,556  us/op
MyBenchmark.testFactShiftTreeForkJoin  10000  avgt   20    1171,646 ±    32,452  us/op
MyBenchmark.testFactShiftTreeForkJoin  50000  avgt   20   14627,024 ±   357,196  us/op
MyBenchmark.testFactTree                  10  avgt   20       0,147 ±     0,004  us/op
MyBenchmark.testFactTree                 100  avgt   20       2,540 ±     0,078  us/op
MyBenchmark.testFactTree                1000  avgt   20      33,496 ±     1,409  us/op
MyBenchmark.testFactTree               10000  avgt   20    1823,560 ±    88,732  us/op
MyBenchmark.testFactTree               50000  avgt   20   27823,839 ±  1022,714  us/op
MyBenchmark.testFourBlocks                10  avgt   20       0,328 ±     0,010  us/op
MyBenchmark.testFourBlocks               100  avgt   20       3,784 ±     0,135  us/op
MyBenchmark.testFourBlocks              1000  avgt   20      74,276 ±     2,289  us/op
MyBenchmark.testFourBlocks             10000  avgt   20    7047,825 ±   208,759  us/op
MyBenchmark.testFourBlocks             50000  avgt   20  182640,939 ±  9012,697  us/op
MyBenchmark.testNaive                     10  avgt   20       0,263 ±     0,005  us/op
MyBenchmark.testNaive                    100  avgt   20       4,045 ±     0,141  us/op
MyBenchmark.testNaive                   1000  avgt   20     184,440 ±     9,611  us/op
MyBenchmark.testNaive                  10000  avgt   20   20956,157 ±   822,248  us/op
MyBenchmark.testNaive                  50000  avgt   20  594264,702 ± 20885,791  us/op
MyBenchmark.testStreamed                  10  avgt   20       0,277 ±     0,009  us/op
MyBenchmark.testStreamed                 100  avgt   20       4,094 ±     0,185  us/op
MyBenchmark.testStreamed                1000  avgt   20     160,802 ±     5,950  us/op
MyBenchmark.testStreamed               10000  avgt   20   20089,014 ±   700,531  us/op
MyBenchmark.testStreamed               50000  avgt   20  566642,732 ± 15943,290  us/op
MyBenchmark.testStreamedParallel          10  avgt   20      11,551 ±     0,375  us/op
MyBenchmark.testStreamedParallel         100  avgt   20      20,562 ±     0,231  us/op
MyBenchmark.testStreamedParallel        1000  avgt   20      42,384 ±     1,478  us/op
MyBenchmark.testStreamedParallel       10000  avgt   20    1373,647 ±    20,357  us/op
MyBenchmark.testStreamedParallel       50000  avgt   20   22250,542 ±   343,414  us/op
MyBenchmark.testStreamedParallelShift     10  avgt   20      11,434 ±     0,165  us/op
MyBenchmark.testStreamedParallelShift    100  avgt   20      21,052 ±     0,270  us/op
MyBenchmark.testStreamedParallelShift   1000  avgt   20      39,929 ±     0,502  us/op
MyBenchmark.testStreamedParallelShift  10000  avgt   20    1243,644 ±    21,475  us/op
MyBenchmark.testStreamedParallelShift  50000  avgt   20   20986,001 ±   420,476  us/op
MyBenchmark.testStreamedShift             10  avgt   20       0,307 ±     0,007  us/op
MyBenchmark.testStreamedShift            100  avgt   20       3,969 ±     0,112  us/op
MyBenchmark.testStreamedShift           1000  avgt   20     143,929 ±     5,329  us/op
MyBenchmark.testStreamedShift          10000  avgt   20   18287,292 ±   528,179  us/op
MyBenchmark.testStreamedShift          50000  avgt   20  528949,557 ± 14937,280  us/op
MyBenchmark.testFactShiftTreeForkJoinMinSize     10  avgt   20     12,881 ?  0,679  us/op
MyBenchmark.testFactShiftTreeForkJoinMinSize    100  avgt   20     30,291 ?  0,081  us/op
MyBenchmark.testFactShiftTreeForkJoinMinSize   1000  avgt   20     60,077 ?  0,253  us/op
MyBenchmark.testFactShiftTreeForkJoinMinSize  10000  avgt   20   1130,127 ?  5,061  us/op
MyBenchmark.testFactShiftTreeForkJoinMinSize  50000  avgt   20  13951,768 ? 70,605  us/op

```