/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static org.sample.FactShiftTree.*;
import static org.sample.FactStreams.*;

@Warmup(iterations=5)
@Measurement(iterations=10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(2)
public class MyBenchmark {

    @Param({"10", "100", "1000", "10000", "50000"})
    private int n;

    @Benchmark
    public void testNaive(Blackhole bh) {
        bh.consume(naive(n));
    }

    @Benchmark
    public void testStreamed(Blackhole bh) {
        bh.consume(streamed(n));
    }

    @Benchmark
    public void testStreamedShift(Blackhole bh) {
        bh.consume(streamedShift(n));
    }

    @Benchmark
    public void testFourBlocks(Blackhole bh) {
        bh.consume(fourBlocks(n));
    }

    @Benchmark
    public void testFactShift(Blackhole bh) {
        bh.consume(factShift(n));
    }

    @Benchmark
    public void testFactTree(Blackhole bh) {
        bh.consume(factTree(n));
    }

    @Benchmark
    public void testFactShiftTree(Blackhole bh) {
        bh.consume(factShiftTree(n));
    }

    @Benchmark
    public void testStreamedParallel(Blackhole bh) {
        bh.consume(streamedParallel(n));
    }

    @Benchmark
    public void testStreamedParallelShift(Blackhole bh) {
        bh.consume(streamedParallelShift(n));
    }

    @Benchmark
    public void testFactShiftTreeForkJoin(Blackhole bh) {
        bh.consume(FactShiftTreeForkJoin.fact(FactShiftTreeForkJoin.sharedPool, n));
    }

}
