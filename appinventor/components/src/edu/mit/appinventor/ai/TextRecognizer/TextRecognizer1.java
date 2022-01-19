package edu.mit.appinventor.ai.TextRecognizer;

import android.net.Uri;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import java.util.ArrayList;


import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.Text.Element;
import com.google.mlkit.vision.text.Text.Line;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

@UsesLibraries(libraries = "googleimage.jar," + "playservicetask.jar," + "textRecognition.jar," + "textRecognition17.jar," + "textRecognitionCommon.jar," +
        "textRecognitionBundledLatin.jar," + "textRecognitionVisionCommon.jar")

@DesignerComponent(version = 1,
        category = ComponentCategory.EXTENSION,
        description = "Extension that allows you to recognize text from images",
        nonVisible = true,
        androidMinSdk = 19,
        iconName = "")

@SimpleObject(external = true)
@UsesPermissions(permissionNames="android.permission.INTERNET")

public final class TextRecognizer1 extends AndroidNonvisibleComponent {

    public TextRecognizer1(ComponentContainer container) {
        super(container.$form());
    }

    public void setRecognizer(InputImage image) {
        ArrayList<String> list = new ArrayList<>();
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        Task<Text> result = recognizer.process(image)
                .addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text visionText) {
                        for (Text.TextBlock block : visionText.getTextBlocks()) {
                            Rect boundingBox = block.getBoundingBox();
                            Point[] cornerPoints = block.getCornerPoints();
                            String text = block.getText();

                            for (Text.Line line: block.getLines()) {
                                // ...
                                for (Text.Element element: line.getElements()) {
                                    // ...
                                }
                            }
                        }
                    }
                 });

    }
}



