package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;
    PromoService myMock;
    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new InMemoryDatabase(); // We probably don't want to access our real database...
        recommender = new RecSysStub();
        // 先用mockito生成mock，然后将mock作为API传给待测类
        // 在测试代码中定义mock的stub行为，待测类调用对应方法后，通过verify验证mock的api是否被调用
        myMock=mock(PromoService.class);
        promoService = myMock;

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
        
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        doNothing().when(myMock).mailTo("yuntaozh");
        andrewWebService.sendPromoEmail("yuntaozh");
        verify(myMock).mailTo("yuntaozh");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        verify(myMock,times(0)).mailTo("yuntaozh");
    }
}
