package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;


@Autonomous(name="AutoconRino_ROJO", group="Robot")
//@Autonomous(name="BlueIzquierda", group="Linear Opmode")
@Disabled
public class AutoConRino_ROJO extends LinearOpMode {

    // Declare OpMode members.
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor MotorIzqAd;
    public DcMotor MotorIzqAt;
    public DcMotor MotorDerAd;
    public DcMotor MotorDerAt;
    public DcMotor Grua;
    public Servo Garra;
    public double angle;
    public ColorSensor color;
    int ColorDrift = 65;
    double TiempoFijo = 0.85;
    double poder = 0.5;
    public double colorD;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        MotorIzqAd = hardwareMap.get(DcMotor.class, "MotorIzquierdoAdelante");
        MotorIzqAt  = hardwareMap.get(DcMotor.class, "MotorIzquierdoAtras");
        MotorDerAd = hardwareMap.get(DcMotor.class, "MotorDerechoAdelante");
        MotorDerAt= hardwareMap.get(DcMotor.class, "MotorDerechoAtras");
        Grua = hardwareMap.get(DcMotor.class, "MotorGrua");
        Garra = hardwareMap.servo.get("ServoGarra");
        color = hardwareMap.get(ColorSensor.class,"sensorColorRange");
//
        MotorIzqAd.setDirection(DcMotor.Direction.REVERSE);
        MotorIzqAt.setDirection(DcMotor.Direction.REVERSE);
        MotorDerAd.setDirection(DcMotor.Direction.FORWARD);
        MotorDerAt.setDirection(DcMotor.Direction.FORWARD);
        Grua.setDirection(DcMotor.Direction.FORWARD);
        Garra.setDirection(Servo.Direction.FORWARD);
        
        waitForStart();
        runtime.reset();
        if (opModeIsActive()){
       //Aqui empieza el programa
            
            GarraCerrar(1);

         
            sleep(1000);
            GruaSubir(0.4);
            sleep(1000);
            Derecha(0.37);
            sleep(1500);
            Adelante(0.118);
            sleep(2000);
            GarraAbrir(3);
            Atras(0.114);
            sleep(1000);
            Izquierda(2);
           // Atras(0.2);
            //Derecha(2);
             
           // Atras(1);
            
          //  Adelante(0.80); //empjar
        //    Esperar(1);
          //  sleep(200);
        //    Atras(0.08); //regreso
          //  sleep(400);
        //    Izquierda(0.25); //iz scan
          //  sleep(1000);
         //   LeerColor(color.red(),color.blue(),color.green());
            
            //Derecha(1);
            //Izquierda(1);
            //VueltaDer(1);
            //VueltaIzq(1);
            //GruaSubir(1);
            //GruaBajar(1);
            //GarraAbrir(1);
            //GarraCerrar(1);
           
            
           
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
     }
    }
    
    public void GruaBajar (double time){
      
        runtime.reset();
        while(runtime.seconds() <= time){
            Grua.setPower(-1);
        }
        Grua.setPower(0);
        
    }
    public void GruaSubir (double time){
     
        runtime.reset();
        while(runtime.seconds()<= time){
            Grua.setPower(1);
        
        }
       Grua.setPower(0);
    }
    public void GarraAbrir (double time){
        runtime.reset();
        while(runtime.seconds() <= time){
            Garra.setPosition(0.7);
        }
        Garra.setPosition(0);
    }
    public void GarraCerrar (double time){
        runtime.reset();
        while(runtime.seconds() <= time){
            Garra.setPosition(-1);
        }
        Garra.setPosition(0);
    }
    
    public void Derecha (double time){
    
        runtime.reset();
        while(runtime.seconds() <= time){
          MotorIzqAd.setPower(poder);
        MotorDerAd.setPower(-poder);
        MotorIzqAt.setPower(-poder);
        MotorDerAt.setPower(poder);
        }
        MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        
    }
    public void Izquierda (double time){
   
        runtime.reset();
        while(runtime.seconds() <= time){
            MotorIzqAd.setPower(-poder);
        MotorDerAd.setPower(poder);
        MotorIzqAt.setPower(poder);
        MotorDerAt.setPower(-poder);
        }
       MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        
    }
    public void Adelante(double time){
      
        runtime.reset();
        while(runtime.seconds() <= time){
            MotorIzqAd.setPower(poder);
        MotorDerAd.setPower(poder);
        MotorIzqAt.setPower(poder);
        MotorDerAt.setPower(poder);
            //Cambiar a mover robot hacia adelante
            
        }
        MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        
    }
    public void Atras (double time){
      
        runtime.reset();
        while(runtime.seconds() <= time){
             MotorIzqAd.setPower(-poder);
        MotorDerAd.setPower(-poder);
        MotorIzqAt.setPower(-poder);
        MotorDerAt.setPower(-poder);
            //Cambiar a mover robot hacia atras
        }
       MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        
    }
    public void VueltaDer(double time){
      
        runtime.reset();
        while(runtime.seconds() <= time){
             MotorIzqAd.setPower(1);
        MotorDerAd.setPower(-1);
        MotorIzqAt.setPower(1);
        MotorDerAt.setPower(-1);
            //Cambiar a girar robot a la derecha
            
        }
        MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        
    }
    
    public void VueltaIzq(double time){
   
        runtime.reset();
        while(runtime.seconds() <= time){
        MotorIzqAd.setPower(-1);
        MotorDerAd.setPower(1);
        MotorIzqAt.setPower(-1);
        MotorDerAt.setPower(1);
        
            
        }
         MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        
    
    }
    
    public void LeerColor(int rojo,int azul,int verde){
    telemetry.addData("RED", color.red());
    telemetry.addData("BLUE", color.blue());
    telemetry.addData("GREEN", color.green());
    telemetry.update();
    sleep(10);
        if(rojo>azul && rojo>verde && rojo>ColorDrift-(ColorDrift*0.80)){ // rojo 1 iz
            colorD = 1;
            Izquierda(0.8);
            
        }
        else if(azul>rojo && azul>verde && azul>ColorDrift){  // azul 3 der
            colorD = 3;
            Derecha(1);
        }
        else if(verde>rojo && verde>azul && verde>ColorDrift+(ColorDrift*0.60)){ // verde 2  cent
            colorD = 2;
            Derecha(0.3);
            Adelante(0.2);
           
        
        }
        else{
        colorD = 0;
        MotorIzqAd.setPower(0);
        MotorDerAd.setPower(0);
        MotorIzqAt.setPower(0);
        MotorDerAt.setPower(0);
        }
    telemetry.addData("color es:",colorD);
    telemetry.update();
    Esperar(1);
    sleep(5000);
    }
    
    public void Esperar (double time){
        runtime.reset();
        while(runtime.seconds() <= time){
        
        }
        
    }
}