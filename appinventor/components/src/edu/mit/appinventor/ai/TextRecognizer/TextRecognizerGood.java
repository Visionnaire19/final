package edu.mit.appinventor.ai.TextRecognizer;


import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;



import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;


import java.io.IOException;


//@UsesLibraries(libraries = "googleimage.jar," + "playservicetask.jar," + "textRecognitionCommon.jar," +
//        "textRecognitionLatin.jar," + "textRecognitionVision.jar")

@UsesLibraries(libraries = "textRecognitionLatin.jar," )

// + "textRecognition.jar," + "textRecognition17.jar,"

@DesignerComponent(version = 1,
        category = ComponentCategory.EXTENSION,
        description = "Extension that allows you to recognize text from images",
        nonVisible = true,
        androidMinSdk = 19,
        iconName = "")

@SimpleObject(external = true)
@UsesPermissions(permissionNames="android.permission.INTERNET")

public final class TextRecognizerGood extends AndroidNonvisibleComponent {
    private static String text = "fjnr3";
    private static String returnList= "";
//    InputImage image;

    public TextRecognizerGood(ComponentContainer container) {
        super(container.$form());

    }

    @SimpleProperty(description = "Input an image and outputs the text on the image")

    public String List(){
        Log.i("TextRecognizer", "External storage is available and writable");
        return returnList;
    }

//    @SimpleProperty()
//    public InputImage inputImage(){
//        return image;
//    }
//    @SimpleProperty()
//    public void inputImage(String path) throws IOException {
//       image = InputImage.fromFilePath(form.getApplicationContext(), Uri.parse(path));
//    }

    @SimpleFunction()
        public void setRecognizer(final String path) throws IOException {

        try{
            TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
            Uri temp = Uri.parse(path);
            InputImage image = InputImage.fromFilePath(form.getApplicationContext(), temp);

            Log.i("TextRecognizer", "i am here!!1");
            recognizer.process(image)
                    .addOnSuccessListener(new OnSuccessListener<Text>() {
                        @Override
                        public void onSuccess(Text visionText) {
                            Log.i("TextRecognizer", "Sucesssss");
                            for (Text.TextBlock block : visionText.getTextBlocks()){
                                String text = block.getText();
                                Result(returnList);
                                returnList = text;


//                            for (Text.Line line: block.getLines()) {
//                                // ...
//                                for (Text.Element element: line.getElements()) {
//                                    // ...
//                                }
//                            }
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            ErrorOccured(path);
                            Log.i("TextRecognizer", "I failed it, but it is an internal problem");
                            returnList = path;

                        }
                    });

        }catch (Exception e){
            Log.i("TextRecognizer", String.valueOf(e));
        }





    }
    @SimpleFunction
    public void newFunction(String path){
        Log.i("TextRecognizer", "Printing path");
        
    }

    @SimpleEvent()
    public void Result(String result){
        EventDispatcher.dispatchEvent(this, "List", result);

    }

        @SimpleEvent(description = "")
    public void ErrorOccured(String error) {

        EventDispatcher.dispatchEvent(this, "ErrorOccured", error);
    }


//    @SimpleProperty()
//    public void jean(String tex){
//        text = tex;
//    }


//    public List recognizeImage(String path) throws IOException {
//
//        ArrayList<String> list = null;
//        try {
//            list = new ArrayList<>();
//            TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
//
//            InputImage image = InputImage.fromFilePath(form.getApplicationContext(), Uri.parse(path));
//
//           final ArrayList<String> finalList = list;
//            recognizer.process(image)
//                    .addOnSuccessListener(new OnSuccessListener<Text>() {
//                        @Override
//                        public void onSuccess(Text visionText) {
//                            for (Text.TextBlock block : visionText.getTextBlocks()) {
//                                Rect boundingBox = block.getBoundingBox();
//                                Point[] cornerPoints = block.getCornerPoints();
//                                String text = block.getText();
//                                finalList.add(text);
//
//                                for (Text.Line line : block.getLines()) {
//                                    // ...
//                                    for (Text.Element element : line.getElements()) {
//                                        // ...
//                                    }
//                                }
//                            }
//                        }
//                    });
//
//
//        } catch (Exception e) {
//            ErrorOccured(e.getMessage());
//
//        }
//
//        return list;
//    }
//
//    @SimpleEvent(description = "")
//    public void ErrorOccured(String error) {
//        EventDispatcher.dispatchEvent(this, "ErrorOccured", error);
//    }
//
//    public void setRecognizer(InputImage image) {
//        ArrayList<String> list = new ArrayList<>();
//        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
//
//        Task<Text> result = recognizer.process(image)
//                .addOnSuccessListener(new OnSuccessListener<Text>() {
//                    @Override
//                    public void onSuccess(Text visionText) {
//                        for (Text.TextBlock block : visionText.getTextBlocks()) {
//                            Rect boundingBox = block.getBoundingBox();
//                            Point[] cornerPoints = block.getCornerPoints();
//                            String text = block.getText();
//                            list.add(text);
//
//                            for (Text.Line line: block.getLines()) {
//                                // ...
//                                for (Text.Element element: line.getElements()) {
//                                    // ...
//                                }
//                            }
//                        }
//                    }
//                 });
//
//    }


}



