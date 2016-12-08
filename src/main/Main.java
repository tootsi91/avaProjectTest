package main;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Tests.GUIexamples.JavaFX.TableSample;

import java.util.ArrayList;
import java.util.Collection;

public class Main extends Application {

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        init(primaryStage);
        primaryStage.show();
    }


    //GUI
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        VBox vbox = new VBox();

        Label grid1Caption = new Label("Java Web Crawler");
        grid1Caption.setWrapText(true);
        GridPane grid1 = new GridPane();
        grid1.setHgap(6);
        grid1.setVgap(6);
        grid1.setPadding(new Insets(18, 18, 18, 18));
        ObservableList<Node> content = grid1.getChildren();

        Label label = new Label("Name:");
        GridPane.setConstraints(label, 0, 0);
        GridPane.setHalignment(label, HPos.RIGHT);
        content.add(label);

        label = new Label("Ats Tootsi");
        GridPane.setConstraints(label, 1, 0, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        content.add(label);

        label = new Label("Gorup:");
        GridPane.setConstraints(label, 0, 1);
        GridPane.setHalignment(label, HPos.RIGHT);
        content.add(label);

        label = new Label("C11");
        GridPane.setConstraints(label, 1, 1, 5, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        content.add(label);

        vbox.getChildren().addAll(grid1Caption, grid1, new Separator());

        Label grid2Caption = new Label("Insert the name of the webpage you want to search below:");
        grid2Caption.setWrapText(true);
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(18, 18, 18, 18));
        grid2.setGridLinesVisible(true);
        RowConstraints rowinfo2 = new RowConstraints();
        rowinfo2.setPercentHeight(50);
        ColumnConstraints colInfo2 = new ColumnConstraints();
        colInfo2.setPercentWidth(50);
        grid2.getRowConstraints().add(rowinfo2);
        grid2.getColumnConstraints().add(colInfo2);
        TextField textBox = new TextField("Insert Link here");
        GridPane.setMargin(textBox, new Insets(10, 10, 10, 10));
        GridPane.setConstraints(textBox, 0, 0);

        Button button = new Button("Search");
        GridPane.setConstraints(button, 1, 0);
        GridPane.setMargin(button, new Insets(10, 10, 10, 10));
        GridPane.setHalignment(button, HPos.CENTER);

        grid2.getChildren().addAll(button, textBox);

        vbox.getChildren().addAll(grid2Caption, grid2);

        root.getChildren().add(vbox);

        Label grid3Caption = new Label("Result table:");
        grid3Caption.setWrapText(true);
        GridPane grid3 = new GridPane();
    }
        //Result table

/*        final ObservableList<Main.Person> data = FXCollections.observableArrayList();
        TableColumn linkCol = new TableColumn();
        linkCol.setText("Links");
        linkCol.setMinWidth(200);
        linkCol.setCellValueFactory(new PropertyValueFactory("Links"));
        TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(linkCol);
        root.getChildren().add(tableView);

        GridPane.setConstraints(linkCol, 0, 0);
        grid3.getChildren().addAll(linkCol);

        vbox.getChildren().addAll(grid3Caption, grid3);

    }*/

        //Start search with button
/*        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                button.setIconified(true);
            }
        });*/

        /*    private void actionSearch() {
                // If stop button clicked, turn crawling flag off.
                if (crawling) {
                    crawling = false;
                    return;
                }
                ArrayList errorList = new ArrayList();
                // Validate that start URL has been entered.
                String startUrl = startTextField.getText().trim();
                if (startUrl.length() < 1) {
                    errorList.add("Missing Start URL.");
                }
                // Verify start URL.
                else if (verifyUrl(startUrl) == null) {
                    errorList.add("Invalid Start URL.");
                }
                // Validate that Max URLs is either empty or is a number.
                int maxUrls = 0;
                String max = ((String) maxComboBox.getSelectedItem()).trim();
                if (max.length() > 0) {
                    try {
                        maxUrls = Integer.parseInt(max);
                    } catch (NumberFormatException e) {
                    }
                    if (maxUrls < 1) {
                        errorList.add("Invalid Max URLs value.");
                    }
                }
                // Validate that matches log file has been entered.
                String logFile = logTextField.getText().trim();
                if (logFile.length() < 1) {
                    errorList.add("Missing Matches Log File.");
                }
                // Validate that search string has been entered.
                String searchString = searchTextField.getText().trim();
                if (searchString.length() < 1) {
                    errorList.add("Missing Search String.");
                }
                // Show errors, if any, and return.
                if (errorList.size() > 0) {
                    StringBuffer message = new StringBuffer();
                    // Concatenate errors into single message.
                    for(int i=0;i<errorList.size(); i++) {
                        message.append(errorList.get(i));
                        if(i+1<errorList.size()) {
                            message.append("\n");
                        }
                    }
                    showError(message.toString());
                    return;
                }
                // Remove "www" from start URL if present.
                startUrl = removeWwwFromUrl(startUrl);
                // Start the Search Crawler.
                search(logFile, startUrl, maxUrls, searchString);
            }*/

/*      //Search method
        String urls[] = new String[1000];
        String url = "http://www.neti.ee";
        int i=0,j=0,tmp=0,total=0, MAX = 1000;
        int start=0, end=0;
        String webpage = Web.getWeb(url);
        end = webpage.indexOf("<body");
        for(i=total;i<MAX; i++, total++){
            start = webpage.indexOf("http://", end);
            if(start == -1){
                start = 0;
                end = 0;
                try{
                    webpage = Web.getWeb(urls[j++]);
                }catch(Exception e){
                    System.out.println("******************");
                    System.out.println(urls[j-1]);
                    System.out.println("Exception caught \n"+e);
                }

                //logic to fetch urls out of body of webpage only
                end = webpage.indexOf("<body");
                if(end == -1){
                    end = start = 0;
                    continue;
                }
            }
            end = webpage.indexOf("\"", start);
            tmp = webpage.indexOf("'", start);
            if(tmp < end && tmp != -1){
                end = tmp;
            }
*//*            url = webpage.substring(start, end);
            urls[i] = url;
            System.out.println(urls[i]);*//*
        }*/

}
