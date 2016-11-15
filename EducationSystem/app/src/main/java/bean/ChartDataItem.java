package bean;

/**
 * Created by tianyun chen on 2016/10/24.
 */
public class ChartDataItem {
    private String Xaxia;
    private float  Yaxia;

    public ChartDataItem(String xaxia, float yaxia) {
        Xaxia = xaxia;
        Yaxia = yaxia;
    }

    public void setXaxia(String xaxia) {
        Xaxia = xaxia;
    }

    public void setYaxia(float yaxia) {
        Yaxia = yaxia;
    }

    public String getXaxia() {
        return Xaxia;
    }

    public float getYaxia() {
        return Yaxia;
    }
}
