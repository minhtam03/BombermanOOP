package com.testniqatsu.bomberman.ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BombermanHUD implements HUD {
    final int padding = 10;

    VBox hud;

    public BombermanHUD() {
        var HUDRow1 = createRow1();
        createHUD(HUDRow1);
    }

//    private HBox createRow0() {
//        var row = new HBox(
//                setTextUI("level", "LEVEL %d"),
//                createSpacer()
//                //setTextUI("time", "⏰ %d")
//        );
//        row.setAlignment(Pos.CENTER_LEFT);
//        row.setPadding(new Insets(0, padding, 0, padding));
//
//        return row;
//    }

    private HBox createRow1() {
        var row = new HBox(
                setTextUI("level", "LEVEL %d"),
                createSpacer(),
                createSpacer(),
                createSpacer(),
                createSpacer(),
                setTextUI("score", "SCORE %d"),
                createSpacer(),
//                setTextUI("speed", "SPEED %d"),
                createSpacer(),
//                setTextUI("flame", "FLAME %d"),
                createSpacer(),
//                setTextUI("bomb", "BOMB %d"),
                createSpacer(),
                setTextUI("life", "❤%d")
                //createSpacer()
                //setTextUI("numOfEnemy", "E %d")
        );
        row.setAlignment(Pos.CENTER_LEFT);
        row.prefWidthProperty().bind(FXGL.getSettings().actualWidthProperty());
        row.setPadding(new Insets(0, padding, 0, padding));

        return row;
    }

    private void createHUD(HBox... rows) {
        hud = new VBox();

        for (var row : rows) {
            hud.getChildren().add(row);
        }

        hud.setPadding(new Insets(padding, 0, padding, 0));
        hud.setSpacing(10);
    }

    private Node createSpacer() {
        var spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    private Text setTextUI(String valGame, String content) {
        var text = FXGL.getUIFactoryService().newText("", 50);
        text.setFill(Color.DEEPPINK);
        text.textProperty().bind(FXGL.getip(valGame).asString(content));
        return text;
    }

    @Override
    public Pane getHUD() {
        return hud;
    }
}
