package app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import task.DBInit;
import task.FileSave;
import task.FileScanner;
import task.ScanCallback;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<FileMeta> fileTable;

    @FXML
    private Label srcDirectory;

    private Thread task;

    public void initialize(URL location, ResourceBundle resources) {
        DBInit.init();
        // 添加搜索框监听器，内容改变时执行监听事件
        searchField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                freshTable();
            }
        });
    }

    public void choose(Event event) {
        // 选择文件目录
        DirectoryChooser directoryChooser=new DirectoryChooser();
        Window window = rootPane.getScene().getWindow();
        File file = directoryChooser.showDialog(window);
        if(file == null)
            return;
        // 获取选择的目录路径，并显示
        String path = file.getPath();

        srcDirectory.setText(path);

        if (task != null ){
            task.interrupt();
        }

        task = new Thread(new Runnable() {
            @Override
            public void run() {
                ScanCallback callback = new FileSave();
                FileScanner scanner = new FileScanner(callback);
                try {
                    System.out.println("执行文件扫描");
                    scanner.scan(path);
                    scanner.waitFinish();
                    System.out.println("任务执行完毕，刷新表格");
                    // TODO
                    freshTable();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
        task.start();
    }

    // 刷新表格数据
    private void freshTable(){
        ObservableList<FileMeta> metas = fileTable.getItems();
        metas.clear();
        // TODO


    }


}