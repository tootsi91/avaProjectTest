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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Tests.GUIexamples.JavaFX.TableSample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Main extends Application {

    private FileCrawler crawler;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

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
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    processPage("www.neti.ee");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                /*label.setText("Searching")*/;
            }


        });

        /*DropShadow shadow = new DropShadow();
        //Adding the shadow when the mouse cursor is on
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                (EventHandler<MouseEvent>) e -> button.setEffect(shadow));
        //Removing the shadow when the mouse cursor is off
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });*/
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

    private URL verifyUrl(String url) {
        // Only allow HTTP URLs.
        if (!url.toLowerCase().startsWith("http://"))
            return null;
        // Verify format of URL.
        URL verifiedUrl = null;
        try {
            verifiedUrl = new URL(url);
        } catch (Exception e) {
            return null;
        }
        return verifiedUrl;
    }


    public static boolean checkExist(String s, File fin) throws IOException {

        FileInputStream fis = new FileInputStream(fin);
        // //Construct the BufferedReader object
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        String aLine = null;
        while ((aLine = in.readLine()) != null) {
            // //Process each line
            if (aLine.trim().contains(s)) {
                //System.out.println("contains " + s);
                in.close();
                fis.close();
                return true;
            }
        }

        in.close();
        fis.close();

        return false;
    }


    public static void processPage(String URL) throws IOException {

        File dir = new File(".");
        String loc = dir.getCanonicalPath() + File.separator + "record.txt";

        // invalid link
        if (URL.contains(".pdf") || URL.contains("@")
                || URL.contains("adfad") || URL.contains(":80")
                || URL.contains("fdafd") || URL.contains(".jpg")
                || URL.contains(".pdf") || URL.contains(".jpg"))
            return;

        // process the url first
        if (URL.contains("www.neti.ee") && !URL.endsWith("/")) {

        } else if (URL.contains("www.neti.ee") && URL.endsWith("/")) {
            URL = URL.substring(0, URL.length() - 1);
        } else {
            // url of other site -> do nothing
            return;
        }

        File file = new File(loc);

        // check existance
        boolean e = checkExist(URL, file);
        if (!e) {
            System.out.println("------ :  " + URL);
            // insert to file
            FileWriter fstream = new FileWriter(loc, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(URL);
            out.newLine();
            out.close();

            Document doc = null;
            try {
                doc = Jsoup.connect(URL).get();
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            }

            if (doc.text().contains("PhD")) {
                //System.out.println(URL);
            }

            Elements questions = doc.select("a[href]");
            for (Element link : questions) {
                processPage(link.attr("abs:href"));
            }
        } else {
            // do nothing
            return;
        }
    }

}


/*    private void actionSearch() {

    }*/
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


