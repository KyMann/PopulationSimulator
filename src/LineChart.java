import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LineChart extends ApplicationFrame {


    public LineChart(String applicationTitle, String chartTitle, String xAxisName, String yAxisName, HashMap<Integer, Integer> data) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                xAxisName,
                yAxisName,
                createDataset(data),
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize( new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(HashMap<Integer, Integer> data) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        if (!data.isEmpty()) {
            for (Map.Entry<Integer, Integer> dataPoint : data.entrySet()) {
                dataSet.addValue(dataPoint.getKey(), "hello", dataPoint.getValue());
            }
        }
        return dataSet;
    }

    public static void main(String[] args) {

        HashMap<Integer, Integer> defaultValues = new HashMap<Integer, Integer>();
            defaultValues.put(5, 1); //keys have to match so that the points are associated...
            defaultValues.put(6, 2);

        LineChart chart = new LineChart(
                "window_title",
                "chart_title",
                "xaxis",
                "yaxis",
                 defaultValues
        );
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
