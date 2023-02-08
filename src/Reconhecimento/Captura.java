package Reconhecimento;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import java.awt.event.KeyEvent;


public class Captura {

    public static void main(String[] args) throws FrameGrabber.Exception {
        KeyEvent tecla = null; // capturar clicando um tecla
        OpenCVFrameConverter.ToMat converteMat = new OpenCVFrameConverter.ToMat(); // convertendo captura, matriz
        // No JavaCV já tem definido o método de conversão
        OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0); //Captura WebCam
        // zero (0) representa o número da camera, no caso WEBCAM

        camera.start(); // throws FrameGrabber.Exception
        // código que pode lançar a exceção FrameGrabber.Exception
        // Janela de preview - Jframe, desenho de uma janela
        // recomendado na documentação = 1/1
        CanvasFrame cFrame = new CanvasFrame("preview", CanvasFrame.getDefaultGamma()/camera.getGamma());
        Frame frameCapturado = null;
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

}
