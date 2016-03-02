package guru.springframework.blog.hibernatepagination.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductDaoTest {
    ProductDao productDao;
    @Before
    public void setUp() throws Exception {
        productDao = new ProductDao();
        productDao.saveProducts();
    }
    @After
    public void cleanUp(){
      productDao.deleteAllProducts();
    }
    @Test
    public void testListPaginatedProductsUsingQuery() throws Exception {
        int count = productDao.listPaginatedProductsUsingQuery(0,10);
        assertEquals(10, count);
    }
    @Test
    public void testListPaginatedProductsUsingCriteria() throws Exception {
        int count=productDao.listPaginatedProductsUsingCriteria(10, 5);
        assertEquals(5,count);
    }
    @Test
    public void testListPaginatedProductsUsingScrollableResultSet() throws Exception {
        int totalProducts=productDao.listPaginatedProductsUsingScrollableResults(0, 3);
        assertEquals(30,totalProducts);
    }
}