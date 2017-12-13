package in.co.praveendeshmane.blog.testingmockitoexample;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    @Mock
    Warehouse mockWarehouse;

    @Test
    public void testInStock() {
       // Warehouse mockWarehouse = mock(Warehouse.class);

        when(mockWarehouse.hasInventory("Talisker", 50)).thenReturn(true);

        Order order = new Order("Talisker", 50);
        order.fill(mockWarehouse);

        assertTrue(order.isFilled());
        verify(mockWarehouse).remove("Talisker", 50);
    }

    @Test
    public void testOutOfStock() {
        //Warehouse mockWarehouse = mock(Warehouse.class);

        when(mockWarehouse.hasInventory("Talisker", 50)).thenReturn(false);

        Order order = new Order("Talisker", 50);
        order.fill(mockWarehouse);

        assertFalse(order.isFilled());
    }
}
