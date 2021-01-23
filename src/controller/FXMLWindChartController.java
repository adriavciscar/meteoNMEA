package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import model.Model;

/**
 * FXML Controller class
 *
 * @author lipez
 */
public class FXMLWindChartController implements Initializable {

    @FXML
    private LineChart<String, Number> chartDirection;
    private XYChart.Series<String, Number> chartDirectionSerie;
    
    @FXML
    private LineChart<String, Number> chartSpeed;
    private XYChart.Series<String, Number> chartSpeedSerie;
    @FXML
    private Slider slider;
    @FXML
    private Text nDirection;
    @FXML
    private Text nSpeed;
    @FXML
    private Text nTemp;
    @FXML
    private Text nPressure;
    
    private Model model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        model = Model.getInstance();
        model.setSizeWindChart(600);
        chartDirectionSerie = model.getTWDSerie();
        chartDirectionSerie.setName("TWD");
        chartSpeedSerie = model.getTWSSerie();
        chartSpeedSerie.setName("TWS");
        
        chartDirection.getData().add(chartDirectionSerie);
        chartSpeed.getData().add(chartSpeedSerie);
    }    
    
}
