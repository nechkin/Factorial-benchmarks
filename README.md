# Factorial-benchmarks
Some algorithms to calculate factorial with benchmarks

Inspired by and based on:
* https://habrahabr.ru/post/255813/
* https://habrahabr.ru/post/255761/

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