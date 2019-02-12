package com.tuandai.thread.mockbase;

import org.junit.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * 默认情况下，所有方法都会返回值，一个 mock 将返回要么 null，一个原始/基本类型的包装值或适当的空集。例如，对于一个 int/Integer 就是 0，而对于 boolean/Boolean 就是 false。
 * <p>
 * Stubbing 可以被覆盖。
 * <p>
 * 一旦 stub，该方法将始终返回一个 stub 的值，无论它有多少次被调用。
 * <p>
 * 最后的 stubbing 是很重要的 – 当你使用相同的参数 stub 多次同样的方法。换句话说：stubbing 的顺序是重要的，但它唯一有意义的却很少，例如当 stubbing 完全相同的方法调用，或者有时当参数匹配器的使用，等等。
 * Created by liusongrui on 2019/1/22.
 */
public class MockStubbingTest {


    @Test
    public void testMockStubbing() throws Exception {
        LinkedList mockedList = mock(LinkedList.class);

//        stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());


        //following prints "first"
        System.out.println(mockedList.get(0));
//following throws runtime exception
//        System.out.println(mockedList.get(1));

        verify(mockedList).get(0);

    }


}
