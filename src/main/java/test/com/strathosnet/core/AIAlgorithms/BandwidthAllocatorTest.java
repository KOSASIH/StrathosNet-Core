package com.strathosnet.core.AIAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BandwidthAllocatorTest {
    private BandwidthAllocator allocator;

    @BeforeEach
    public void setUp() {
        allocator = new BandwidthAllocator();
    }

    @Test
    public void testAllocateBandwidth() {
        boolean result = allocator.allocate("satellite1", 100);
        assertTrue(result, "Should allocate bandwidth successfully");
    }

    @Test
    public void testDeallocateBandwidth() {
        allocator.allocate("satellite1", 100);
        boolean result = allocator.deallocate("satellite1", 100);
        assertTrue(result, "Should deallocate bandwidth successfully");
    }
}
