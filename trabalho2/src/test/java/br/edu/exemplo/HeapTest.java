package br.edu.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HeapTest {

    @Test
    public void testOrdenado() {
        String[] a = { "aaa", "bbb", "ccc", "ddd" };
        String[] result = { "aaa", "bbb", "ccc", "ddd" };
        Heap.sort(a);
        assertArrayEquals(result, a);
    }

    @Test
    public void testIsSorted() {
        String[] a = { "fffffff", "bbb", "eeeeeeeeeee", "dddddd" };
        Heap.sort(a);
        assertTrue(Heap.isSorted(a));
    }

    @Test
    public void testNumeros() {
        String[] a = { "5", "3", "4", "2", "1" };
        Heap.sort(a);
        String result = Heap.show(a);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    public void testReadStringsStopsOnEmptyLine() {
        String input = "um\ndois\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        String[] result = HeapMain.readStrings();
        assertArrayEquals(new String[] { "um", "dois" }, result);
    }

    @Test
    public void testReadStringsStopsOnEOF() {
        String input = "a\nb\nc";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        String[] result = HeapMain.readStrings();
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    public void testEmptyInput() {
        String[] a = {};
        Heap.sort(a);
        assertEquals("", Heap.show(a));
    }

    @Test
    public void testSingleInput() {
        String[] a = { "unico" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "unico" }, a);
    }

    @Test
    public void testUpToFiveStrings() {
        String[] a = { "e", "c", "b", "d", "a" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "a", "b", "c", "d", "e" }, a);
    }

    @Test
    public void testSixStringsResize() {
        String[] a = { "f", "e", "d", "c", "b", "a" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "a", "b", "c", "d", "e", "f" }, a);
    }

    @Test
    public void testAlreadySorted() {
        String[] a = { "a", "b", "c" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "a", "b", "c" }, a);
    }

    @Test
    public void testReverseOrder() {
        String[] a = { "d", "c", "b", "a" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "a", "b", "c", "d" }, a);
    }

    @Test
    public void testWithDuplicates() {
        String[] a = { "x", "a", "x", "b" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "a", "b", "x", "x" }, a);
    }

    @Test
    public void testCaseSensitive() {
        String[] a = { "b", "A", "a", "Z" };
        Heap.sort(a);
        assertArrayEquals(new String[] { "A", "Z", "a", "b" }, a);
    }

    @Test
    public void testWithSpaces() {
        String[] a = { "  espaco", "espaco", " meio " };
        Heap.sort(a);
        assertArrayEquals(new String[] { "  espaco", " meio ", "espaco" }, a);
    }

    @Test
    public void testWithUnicode() {
        String[] a = { "ç", "Á", "b" };
        Heap.sort(a);
        assertTrue(Heap.isSorted(a));
    }

}
