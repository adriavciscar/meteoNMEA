package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.text.Text;
import model.Model;

/**
 * FXML Controller class
 *
 * @author lipez
 */
public class FXMLTempChartController implements Initializable {

    private XYChart.Series<String, Number> chartTempSerie;
    @FXML
    private Slider slider;
    @FXML
    private Text nDirection;
    @FXML
    private Text nSpeed;
    @FXML
    private Text nTemp;
    @FXML
    private Text nTemp1;
    @FXML
    private Text nPressure;
    @FXML
    private Text nPressure1;
    
    private Model model;
    @FXML
    private LineChart<String, Number> chartTemp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        model = Model.getInstance();
        
        slider.valueProperty().addListener((a, b, c) -> {
            int size = (int)Math.round((double) c * 60); 
            //System.out.println(size);
            model.setSizeTempChart(size);
        });
        
        model.setSizeTempChart(300);
        chartTempSerie = model.getTempSerie();
        chartTempSerie.setName("Temperatura");
        
        chartTemp.getData().add(chartTempSerie);
        
        model.barometricPressureProperty().addListener((a, b, c) -> {
            String dat = String.valueOf(c);
            // + " " + model.getBarometricUnit()
            Platform.runLater(() -> {
                nPressure.setText(dat);
            });
        });
        model.TEMPProperty().addListener((a, b, c) -> {
            String dat = String.valueOf(c);
            Platform.runLater(() -> {
                nTemp.setText(dat);
            });
        });

        model.TWDProperty().addListener((a, b, c) -> {
            String dat = String.valueOf(c);
            Platform.runLater(() -> {
                nDirection.setText(dat);
            });
        });
        model.TWSProperty().addListener((a, b, c) -> {
            String dat = String.valueOf(c);
            Platform.runLater(() -> {
                nSpeed.setText(dat);
            });
        });
    }    


    
}
