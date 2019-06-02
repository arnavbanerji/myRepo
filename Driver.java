
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Driver extends Application {

    static double[][][] TRAINING_DATA =
            {
                    {{1.0, 400}, {800}},
                    {{1.0, 450}, {820}},
                    {{1.0, 500}, {980}},
                    {{1.0, 550}, {990}},
                    {{1.0, 600}, {920}},
                    {{1.0, 650}, {1250}},
                    {{1.0, 700}, {1280}},
                    {{1.0, 750}, {1400}},
                    {{1.0, 800}, {1350}},
                    {{1.0, 850}, {1430}},
                    {{1.0, 900}, {1550}},
                    {{1.0, 950}, {1600}},
                    {{1.0, 1000}, {1700}},
                    {{1.0, 1050}, {1800}},
                    {{1.0, 1100}, {1900}},
            };

    static LinearRegression lr;
    public static void main(String[] args) throws Exception {
        double[][] xArray = new double[TRAINING_DATA.length][TRAINING_DATA[0][0].length];
        double[][] yArray = new double[TRAINING_DATA.length][1];
        IntStream.range(0,TRAINING_DATA.length).forEach( i -> {
            IntStream.range(0,TRAINING_DATA[0][0].length).forEach(j -> xArray[i][j] = TRAINING_DATA[i][0][j]);
            yArray[i][0] = TRAINING_DATA[i][1][0];
        });
        lr = new LinearRegression(xArray, yArray);
        launch(); // launch will trigger overriden stage method
    }

    static void handleCommandLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("to estimate rent, enter apartment size in square feet OR exit");
            try {
                String entry = bufferedReader.readLine();
                if (!entry.equals("exit")) { System.out.println("estimated price is $"+lr.estimateRent(entry)); }
                else { System.exit(0); }
            } catch(Exception e) {
                System.out.println("invalid input");
            }
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Platform.setImplicitExit(false);
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        IntStream.range(0, Driver.TRAINING_DATA.length).forEach( i ->
            series1.getData().add(new XYChart.Data<>(Driver.TRAINING_DATA[i][0][1],Driver.TRAINING_DATA[i][1][0])));
        IntStream.range(0, Driver.TRAINING_DATA.length).forEach( i ->
            series2.getData().add(new XYChart.Data<>(Driver.TRAINING_DATA[i][0][1], lr.getEstimate().getEntry(i,0))));
        NumberAxis xAxis = new NumberAxis(0,1500,400);
        xAxis.setLabel(">>> size in square feet");
        NumberAxis yAxis = new NumberAxis(0,2200,700);
        yAxis.setLabel(">>> rent in $");
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis,yAxis);
        scatterChart.getData().add(series1);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().add(series2);
        lineChart.setOpacity(0.4);
        Pane pane = new Pane();
        pane.getChildren().addAll(scatterChart,lineChart);
        primaryStage.setScene(new Scene(pane, 580, 370));
        primaryStage.setOnHidden(e -> { try { handleCommandLine(); } catch (Exception e1) { e1.printStackTrace();}});
        System.out.println("close display windows to proceed");
        primaryStage.setTitle("linear regression - my first step of ML");
        primaryStage.show();
    }
}
