package Reconhecimento;//papckage Reconhecimento;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.objdetect.CascadeClassifier;
import java.awt.event.KeyEvent;


public class CapturaDeteccao {

    public static void main(String[] args) throws FrameGrabber.Exception {
        KeyEvent tecla = null; // capturar clicando um tecla
        OpenCVFrameConverter.ToMat converteMat = new OpenCVFrameConverter.ToMat(); // convertendo captura, matriz
        // No JavaCV já tem definido o método de conversão
        OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0); //Captura WebCam
        // zero (0) representa o número da camera, no caso WEBCAM

        camera.start(); // throws FrameGrabber.Exception
        // código que pode lançar a exceção FrameGrabber.Exception
        // detecção de faces com Cascade
        CascadeClassifier detectorFace;

        detectorFace = new CascadeClassifier("src/recursos/");

        // Janela de preview - Jframe, desenho de uma janela
        // recomendado na documentação = 1/1
        CanvasFrame cFrame = new CanvasFrame("preview", CanvasFrame.getDefaultGamma()/camera.getGamma());
        Frame frameCapturado = null;
        Mat imagemColorida = new Mat(); // jolgar o que está em frame capturado
        // Recebe WEBCAM (camera.grab) e guarda em frameCapturado
        while ((frameCapturado = camera.grab()) != null){
            //Se visível, mostrar = showImage
            if(cFrame.isValid()){
                cFrame.showImage(frameCapturado);
            }

        }

        //cFrame.dispose();
        //camera.stop();

    }

    private static void rectangle(Mat imagemColorida, int[] dadosFace, Scalar scalar) {
    }

}