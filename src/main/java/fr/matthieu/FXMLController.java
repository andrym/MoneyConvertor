package fr.matthieu;
/*
Put header here


 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    private float res;

    @FXML
    private TextField tfToConvert;
    @FXML
    private ComboBox<Currency> cbxCurrencyToConvert, cbxConvertedCurrency;
    @FXML
    private Label lblCurrencySymbol, lblCurrentMoney, lblConversionRate, lblConvertResult;

    @FXML
    public void onConvertAction() {
        if (!tfToConvert.getText().isEmpty()) {
            res = Float.parseFloat(tfToConvert.getText());
            res /= cbxCurrencyToConvert.getValue().getConvertValue();
            res *= cbxConvertedCurrency.getValue().getConvertValue();
            lblConvertResult.setText(String.format("%.2f", res));
        }
    }

    @FXML
    public void onCurrencyChange() {
        lblCurrencySymbol.setText(" " + cbxConvertedCurrency.getValue().getSymbol());
        lblConversionRate.setText(String.format("%.3f", (cbxConvertedCurrency.getValue().getConvertValue()
                / cbxCurrencyToConvert.getValue().getConvertValue())));
    }

    @FXML
    public void onToConvertChange() {
        lblCurrentMoney.setText(cbxCurrencyToConvert.getValue().getSymbol());
        lblConversionRate.setText(String.format("%.3f", (cbxConvertedCurrency.getValue().getConvertValue()
                / cbxCurrencyToConvert.getValue().getConvertValue())));
    }

    @FXML
    public void onClearAction() {
        tfToConvert.setText("");
        lblConvertResult.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblConvertResult.setText("0");
        cbxCurrencyToConvert.getItems().setAll(Currency.values());
        cbxCurrencyToConvert.getSelectionModel().selectFirst();
        cbxConvertedCurrency.getItems().setAll(Currency.values());
        cbxConvertedCurrency.getSelectionModel().select(1);
        lblCurrencySymbol.setText(" " + cbxConvertedCurrency.getValue().getSymbol());
        lblCurrentMoney.setText(cbxCurrencyToConvert.getValue().getSymbol());
        lblConversionRate.setText(String.format("%.3f", (cbxConvertedCurrency.getValue().getConvertValue()
                / cbxCurrencyToConvert.getValue().getConvertValue())));
    }
}
