package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapTest {
    @Test
    public void test1() {
        DashaMap dm = new DashaMap();
        dm.set("frog", 2);
        dm.set("bat", 9);

        dm.delete("frog");
        int size = dm.bucketSize("b");
        Assert.assertFalse(dm.isEmpty());
        Assert.assertEquals(1, size);
    }

    @Test
    public void test2() {
        DashaMap dm = new DashaMap();
        dm.set("frog", 2);
        dm.set("bat", 9);
        dm.set("bowl", 5);

        Assert.assertFalse(dm.isEmpty());
        Assert.assertEquals(2, dm.bucketSize("b"));

        Assert.assertEquals(3, (int) dm.size());

        Assert.assertEquals(2, (int) dm.get("frog"));
    }

    @Test
    public void test3() {
        DashaMap dm = new DashaMap();

        Assert.assertTrue(dm.isEmpty());
    }

    @Test
    public void test4() {
        DashaMap dm = new DashaMap();

        dm.readFromFile();

        for (int i=97; i<123; i++) {
            char key = (char) i;
            System.out.println(key + "\t" + dm.bucketSize(String.valueOf(key)));
        }
    }
}
