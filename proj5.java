import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class proj5 extends Application {
	Label investment;
	Label annualRate;
	Label years;
	Label finalWorth;
	TextField textInvestment;
	TextField textAnnualRate;
	TextField textYear;
	TextField textWorth;

	@Override

	public void start(Stage primaryStage) throws Exception {
		
		//Labels and text fields 
		investment = new Label("Money used in investment:");
		textInvestment = new TextField();
		years=new Label("Years:");
		textYear = new TextField();
		annualRate = new Label("Annual interest rate:");
		textAnnualRate = new TextField();		
		finalWorth = new Label("Final financial worth:");
		textWorth = new TextField();
		textWorth.setEditable(false);

		//Button to calculate finalWorth
		Button calcButton = new Button("Calculate");
		calcButton.setOnAction(e -> calculate());
		
		//Grid for labels, text fields, and button
		GridPane grid = new GridPane();
		grid.setVgap(5);
		grid.setHgap(5);
		grid.add(investment, 0, 0);
		grid.add(textInvestment, 1, 0);
		grid.add(years, 0, 1);
		grid.add(textYear, 1, 1);
		grid.add(annualRate, 0, 2);
		grid.add(textAnnualRate, 1, 2);
		grid.add(finalWorth, 0, 3);
		grid.add(textWorth, 1, 3);
		grid.add(calcButton, 1, 4);
		
		//Creating a flow pane object for label and grid
		FlowPane flowPane = new FlowPane();
		flowPane.setVgap(20);
		FlowPane.setMargin(grid, new Insets(30, 30, 30, 30));
		flowPane.getChildren().addAll(grid);
		
		//Creating scene and setting stage
		Scene scene = new Scene(flowPane, 360, 280);
		primaryStage.setTitle("Financial Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void calculate() {
		//Get user input
		double investment = Double.parseDouble(textInvestment.getText());
		double annualRate = Double.parseDouble(textAnnualRate.getText());
		int years = Integer.parseInt(textYear.getText());
		double monthlyRate = annualRate/1200;
		
		//Calculate final financial worth
		double finalFinancialWorth = investment * (Math.pow((1 + monthlyRate),(years * 12)));
		textWorth.setText(String.format("%.2f",finalFinancialWorth));
	}
	public static void main(String[] args) {
		
		launch(args);

	}

}