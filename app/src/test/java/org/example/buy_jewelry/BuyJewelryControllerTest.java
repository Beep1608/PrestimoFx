package org.example.buy_jewelry;

//import javafx.embed.swing.JFXPanel;
//import javafx.scene.layout.Region;
//import javafx.scene.layout.VBox;
//import org.example.buy_caratages_percentages.BuyCaratagePercentagesController;
//import org.example.buy_caratages_percentages.BuyCaratagePercentagesModel;
//import org.example.buy_caratages_percentages.BuyCaratagePercentagesObject;
//import org.example.buy_caratages_percentages.BuyCaratagePercentagesView;
//import org.example.buy_percentages.BuyPercentageObject;
//import org.example.buy_percentages.BuyPercentageView;
//import org.example.buy_percentages.BuyPercentagesController;
//import org.example.buy_percentages.BuyPercentagesModel;
//import org.example.clients.ClientObject;
//import org.example.constants.ConstantsController;
//import org.example.constants.ConstantsModel;
//import org.example.constants.ConstantsObject;
//import org.example.currency_prices.CurrencyPricesObject;
//import org.example.jewelry.JewelryController;
//import org.example.jewelry.JewelryModel;
//import org.example.jewelry.JewelryObject;
//import org.example.jewelry.JewelryView;
//import org.example.loan_jewelry.LoanJewelryObject;
//import org.example.metal_prices.MetalPricesController;
//import org.example.metal_prices.MetalPricesModel;
//import org.example.metal_prices.MetalPricesObject;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//
//public class BuyJewelryControllerTest {
//    private JewelryController jewelryController;
//    private BuyPercentagesController buyPercentagesController;
//    private BuyCaratagePercentagesController buyCaratagePercentagesController;
//    private MetalPricesController metalPricesController;
//    private ConstantsController constantsController;
//    private Session session;
//
//    private BuyJewelryController controller;
//
//    public static Session hibernate(){
//        SessionFactory sessionFactory;
//        var config = new Configuration().configure()
//                .addAnnotatedClass(JewelryObject.class)
//                .addAnnotatedClass(BuyPercentageObject.class)
//                .addAnnotatedClass(BuyCaratagePercentagesObject.class)
//                .addAnnotatedClass(MetalPricesObject.class)
//                .addAnnotatedClass(CurrencyPricesObject.class)
//                .addAnnotatedClass(ConstantsObject.class)
//                .addAnnotatedClass(BuyJewelryObject.class)
//                .addAnnotatedClass(LoanJewelryObject.class)
//                .addAnnotatedClass(ClientObject.class);
//        sessionFactory = config.buildSessionFactory();
//        return  sessionFactory.openSession();
//    }
//    @BeforeEach
//    public void setUp() {
//        new JFXPanel();
//
//       session = hibernate();
//        jewelryController = new JewelryController(session);
//        buyPercentagesController = new BuyPercentagesController(session);
//        buyCaratagePercentagesController = new BuyCaratagePercentagesController(session);
//        metalPricesController =new MetalPricesController(session);
//        constantsController = new ConstantsController(session);
//
//
//        // Crear el controller real
//        controller = new BuyJewelryController(
//                jewelryController,
//                buyPercentagesController,
//                buyCaratagePercentagesController,
//                metalPricesController,
//                constantsController,
//                session
//        );
//    }
//
//
//    @Test
//    public void testModelNotNull() {
//        BuyJewelryModel model = controller.getModel();
//        assertNotNull(model);
//    }
//
//    @Test
//    public void testCreateActionSetsCreateModelTrue() {
//        controller.getModel().create().set(true);
//        assertTrue(controller.getModel().create().get());
//        assertFalse(controller.getModel().index().get());
//        assertFalse(controller.getModel().edit().get());
//    }
//}
