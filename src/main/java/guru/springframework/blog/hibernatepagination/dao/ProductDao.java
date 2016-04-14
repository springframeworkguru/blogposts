package guru.springframework.blog.hibernatepagination.dao;

import guru.springframework.blog.hibernatepagination.domain.Product;
import guru.springframework.blog.hibernatepagination.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProductDao {
    public void saveProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            for (int i = 0; i < 30; i++) {
                Product product = new Product();
                product.setProductName("Product_" + i);
                session.save(product);
            }
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Saved 30 products");
    }

    public int listPaginatedProductsUsingQuery(int firstResult, int maxResults) {
        int paginatedCount = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("From Product");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            List<Product> products = (List<Product>) query.list();
            if (products != null) {
                paginatedCount = products.size();
                System.out.println("Total Results: " + paginatedCount);
                for (Product product : products) {
                    System.out.println("Retrieved Product using Query. Name: " + product.getProductName());
                }
            }

        } catch (HibernateException e) {
            e.printStackTrace();

        } finally {
            session.close();
        }
        return paginatedCount;
    }


    public int listPaginatedProductsUsingCriteria(int firstResult, int maxResults) {
        int paginatedCount = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Product.class);
            criteria.setFirstResult(firstResult);
            criteria.setMaxResults(maxResults);
            List<Product> products = (List<Product>) criteria.list();
            if (products != null) {
                paginatedCount = products.size();
                System.out.println("Total Results: " + paginatedCount);
                for (Product product : products) {
                    System.out.println("Retrieved Product using Criteria. Name: " + product.getProductName());
                }
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return paginatedCount;
    }

    public int listPaginatedProductsUsingScrollableResults(int firstResult, int maxResults ) {
        int totalRecords=0;
        final Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            ScrollableResults  scrollableResults = getCriteria(session).scroll();
            scrollableResults.last();
            totalRecords=scrollableResults.getRowNumber()+1;
            scrollableResults.close();
            Criteria criteria = getCriteria(session);
            criteria.setFirstResult(firstResult);
            criteria.setMaxResults(maxResults);
            List<Object[]> products = criteria.list();
            if (products != null) {
                for (Object[] product : products) {
                    System.out.println("Retrieved Product using ScrollableResults. Name: " + product[0] + " out of "+totalRecords + " products");
                }
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return totalRecords;

    }

    private static Criteria getCriteria(final Session session) {
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.isNotNull("productName"));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("productName"))
                .add(Projections.property("id")));
        criteria.addOrder(Order.asc("id"));
        return criteria;
    }

    public void deleteAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try {
            trans = session.beginTransaction();
            String hql = String.format("delete from Product");
            Query query = session.createQuery(hql);
            query.executeUpdate();
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("Deleted all products");

    }
}




