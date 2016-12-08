package main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        init(primaryStage);
        primaryStage.show();
    }

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        VBox vbox = new VBox();

        //grid1 places the child by specifying the rows and columns in
        // GridPane.setContraints()
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

        //grid2 places the child by influencing the rows and columns themselves
        //via GridRowInfo and GridColumnInfo. This grid uses the preferred
        //width/height and max/min width/height.

        /*Label grid2Caption = new Label("The example below shows GridPane content placement by influencing the rows and columns themselves.");
        grid2Caption.setWrapText(true);
        grid2Caption.setWrapText(true);
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(18, 18, 18, 18));
        RowConstraints rowinfo = new RowConstraints(40, 40, 40);
        ColumnConstraints colinfo = new ColumnConstraints(90, 90, 90);

        for (int i = 0; i <= 2; i++) {
            grid2.getRowConstraints().add(rowinfo);
        }

        for (int j = 0; j <= 2; j++) {
            grid2.getColumnConstraints().add(colinfo);
        }

        Label category = new Label("Category:");
        GridPane.setHalignment(category, HPos.RIGHT);
        Label categoryValue = new Label("Wines");
        Label company = new Label("Company:");
        GridPane.setHalignment(company, HPos.RIGHT);
        Label companyValue = new Label("Acme Winery");
        Label rating = new Label("Rating:");
        GridPane.setHalignment(rating, HPos.RIGHT);
        Label ratingValue = new Label("Excellent");

*//*        ImageView imageView = new ImageView(ICON_48);
        GridPane.setHalignment(imageView, HPos.CENTER);*//*

        //Place content
        GridPane.setConstraints(category, 0, 0);
        GridPane.setConstraints(categoryValue, 1, 0);
        GridPane.setConstraints(company, 0, 1);
        GridPane.setConstraints(companyValue, 1, 1);
*//*        GridPane.setConstraints(imageView, 2, 1);*//*
        GridPane.setConstraints(rating, 0, 2);
        GridPane.setConstraints(ratingValue, 1, 2);
        grid2.getChildren().addAll(category, categoryValue, company, companyValue*//*, imageView*//*, rating, ratingValue);

        vbox.getChildren().addAll(grid2Caption, grid2, new Separator());*/

        //grid3 places the child by influencing the rows and columns
        //via GridRowInfo and GridColumnInfo. This grid uses the percentages
        Label grid3Caption = new Label("Insert the name of the webpage you want to search below:");
        grid3Caption.setWrapText(true);
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(18, 18, 18, 18));
        grid3.setGridLinesVisible(true);
        RowConstraints rowinfo2 = new RowConstraints();
        rowinfo2.setPercentHeight(50);

/*        ColumnConstraints colInfo2 = new ColumnConstraints();
        colInfo2.setPercentWidth(25);*/

        ColumnConstraints colInfo2 = new ColumnConstraints();
        colInfo2.setPercentWidth(50);

        grid3.getRowConstraints().add(rowinfo2);/*//2*50 percent
        grid3.getRowConstraints().add(rowinfo2);*/

/*        grid3.getColumnConstraints().add(colInfo2); //25 percent*/
        grid3.getColumnConstraints().add(colInfo2); //50 percent
/*        grid3.getColumnConstraints().add(colInfo2); //25 percent*/

/*        Label condLabel = new Label(" Member Name:");
        GridPane.setHalignment(condLabel, HPos.RIGHT);
        GridPane.setConstraints(condLabel, 0, 0);*/
/*        Label condValue = new Label("MyName");
        GridPane.setMargin(condValue, new Insets(0, 0, 0, 10));
        GridPane.setConstraints(condValue, 1, 0);*/

/*        Label acctLabel = new Label("Member Number:");
        GridPane.setHalignment(acctLabel, HPos.RIGHT);
        GridPane.setConstraints(acctLabel, 0, 1);*/
        TextField textBox = new TextField("Insert Link here");
        GridPane.setMargin(textBox, new Insets(10, 10, 10, 10));
        GridPane.setConstraints(textBox, 0, 0);

        Button button = new Button("Search");
        GridPane.setConstraints(button, 1, 0);
        GridPane.setMargin(button, new Insets(10, 10, 10, 10));
        GridPane.setHalignment(button, HPos.CENTER);

/*
        GridPane.setConstraints(condValue, 1, 0);
*/
        grid3.getChildren().addAll(/*condLabel,*/ /* condValue,*/ button/*, acctLabel*/, textBox);

        vbox.getChildren().addAll(grid3Caption, grid3);

        root.getChildren().add(vbox);

    }



    //GUI test

 /*   private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        Label label = new Label("Test Label:");
        TextField tb = new TextField();
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(label, tb);
        hbox.setAlignment(Pos.CENTER);
        root.getChildren().add(hbox);
        //create a button for initializing our new stage
        Button button = new Button("Start Crawler");
        button.setStyle("-fx-font-size: 26;");
        button.setDefaultButton(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                final Stage stage = new Stage();
                //create root node of scene, i.e. group
                Group rootGroup = new Group();
                //create scene with set width, height and color
                Scene scene = new Scene(rootGroup, 400, 400, Color.LIGHTSKYBLUE);
                //set scene to stage
                stage.setScene(scene);
                //center stage on screen
                stage.centerOnScreen();
                //show the stage
                stage.show();
                //add some node to scene
                *//*Text text = new Text(20, 110, "JavaFX");*//*
                Text text = new Text(20, 110, "JavaFX");
                text.setFill(Color.BLACK);
                text.setEffect(new Lighting());
                text.setFont(Font.font(Font.getDefault().getFamily(), 50));
                //add text to the main root group
                rootGroup.getChildren().add(text);
            }

        }

        );

        root.getChildren().add(button);
    }

    public double getSampleWidth() { return 400; }

    public double getSampleHeight() { return 100; }
*/

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
