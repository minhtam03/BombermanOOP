package com.testniqatsu.bomberman.menus;

import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MenuButton extends Parent {
    Text text;

    MenuButton(String name, Runnable action) {
        this(name, 50, action);
    }

    MenuButton(String name, int size, Runnable action) {
        text = FXGL.getUIFactoryService().newText(name, Color.WHITE, size);
        text.setStrokeWidth(1.5);
        text.strokeProperty().bind(text.fillProperty());

        text.fillProperty().bind(
                Bindings.when(hoverProperty())
                        .then(Color.OLIVEDRAB)
                        .otherwise(Color.WHITE)
        );

        setOnMouseClicked(e -> action.run());
//        setOnKeyPressed(keyEvent -> {
//            KeyCode code = keyEvent.getCode();
//            if (code == KeyCode.ENTER) {
//                action.run();
//            }
//        });

        setPickOnBounds(true);

        getChildren().add(text);
    }
}
