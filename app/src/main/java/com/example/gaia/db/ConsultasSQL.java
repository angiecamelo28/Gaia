package com.example.gaia.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ConsultasSQL {

    public final String TABLA_HUERTA =
            "CREATE TABLE HUERTA("+
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "NOMBRE TEXT NOT NULL,"+
                    "AREA INTEGER NOT NULL,"+
                    "TEMPERATURA INTEGER,"+
                    "HUMEDAD INTEGER," +
                    "PROPIETARIO TEXT NOT NULL,"+
                    "DESCRIPCION TEXT)";

    public final String TABLA_CULTIVO =
            "CREATE TABLE CULTIVO("+
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "NOMBRE TEXT NOT NULL,"+
                    "TIEMPOCOSECHA INTEGER NOT NULL,"+
                    "FECHASIEMBRA TEXT NOT NULL,"+
                    "ESTADO TEXT,"+
                    "TIPOCULTIVO TEXT NOT NULL,"+
                    "CLIMA TEXT NOT NULL,"+
                    "TEMPERATURA TEXT NOT NULL,"+
                    "HUMEDAD INTEGER NOT NULL,"+
                    "FRECUENCIAABONADO TEXT,"+
                    "FRECUENCIARIEGO TEXT,"+
                    "FRECUENCIAFUMIGACION TEXT,"+
                    "DISTANCIASEMILLAS INTEGER,"+
                    "PLAGASENFERMEDADES TEXT,"+
                    "PREVENCIONCUIDADOS TEXT," +
                    "IMAGEN INTEGER)";

    public final String TABLA_CULTIVO_HUERTA=
            "CREATE TABLE CULTIVO_HUERTA("+
                    "CULTIVOID INTEGER,"+
                    "HUERTAID INTEGER,"+
                    "CONSTRAINT FK_HUERTA FOREIGN KEY(HUERTAID) REFERENCES HUERTA(ID),"+
                    "CONSTRAINT FK_CULTIVO FOREIGN KEY(CULTIVOID) REFERENCES CULTIVO(ID))";

    public final String TABLA_HISTORIAL_NOTIFICACIONES=
            "CREATE TABLE HISTORIAL_NOTIFICACIONES("+
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "FECHA TEXT,"+
                    "TITULO TEXT,"+
                    "CONTENIDO TEXT)";


    public void llenarTablas(Context context){
        ConexionDB conexion = new ConexionDB(context.getApplicationContext(), "Gaia.db", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        if (db != null){
            db.execSQL("DELETE FROM HUERTA");
            db.execSQL("DELETE FROM CULTIVO");
            db.execSQL("DELETE FROM CULTIVO_HUERTA");
            //db.execSQL("DELETE FROM HISTORIAL_NOTIFICACIONES");
            //inserciones huerta
            db.execSQL("insert into huerta (nombre,area,TEMPERATURA,HUMEDAD,PROPIETARIO,DESCRIPCION) values ('Cañon','125','22','76','Pepe Perez','Cultivos mixtos (fruta - verdura)')");
            db.execSQL("insert into huerta (nombre,area,TEMPERATURA,HUMEDAD,PROPIETARIO,DESCRIPCION) values ('La granja','500','25','80','Jose Restrepo','Cultivo del campo para la venta')");
            db.execSQL("insert into huerta (nombre,area,TEMPERATURA,HUMEDAD,PROPIETARIO,DESCRIPCION) values ('Cienaga','320','28','72','Jhon Angulo','Cultivos de fruta y verdura')");
            //inserciones cultivo
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Tomate', '70 dias', '12/05/2022','Estable', 'Fruta', 'Tropical', '22.5','68 %','3 semanas','3 vez/semana','2 vez/mes','40 cm', 'cladosporiosis,mildiu,oidiopsis,podredumbre gris','suficiente sol,agua,abono,poda,suelo profundo',2131165371)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Papa', '100 dias', '05/1/2022','Estable', 'Verdura', 'Tropical', '23','93 %','4 semanas','2 vez/semana','1 vez/mes','90 cm', 'escarabajo de la papa,polilla de la papa,mosca minadora,nemátodo del quiste,tizón tardío,marchitez bacteriana','clima templado,suelo ligero y profundo,sol, abono rico en fosforo y rico en potasio',2131165364)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Yuca', '250 dias', '11/10/2022','Estable', 'Tubérculo', 'Tropical', '24','72 %','2 semanas','1 vez/semana','2 vez/mes','80 cm', 'roya de la yuca,añublo pardo fungoso,añublo bacteriano,necrosamiento del tallo,pudrición seca de tallo y raíz,pudrición bacteriana del tallo','mucha luz,temperaturas templadas,abonado, riego, transplante cada 2 años',2131165375)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Fresas', '160 dias', '22/02/2022','Estable', 'Fruta', 'Templado', '17.5','70 %','13 semanas','1 vez/semana','N/A','30 cm', 'araña de dos manchas,gallina ciega,gusano cogollero,gusano del fruto,trips,pulgones','proreccion de los vientos fuertes,suficiente luz y agua,sustrato rico en humus',2131165288)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Moras', '213 dias', '10/08/2022','Estable', 'Fruta', 'Templado', '16.5','75 %','17 semanas','1 vez/semana','N/A','200 cm', 'mildeo polvoso,mildeo velloso,ohytophthora,agalla de la corona,barrenador del tallo,perla de tierra,antracnosis','mucho sol,suelo limoso,suelo humedo,suelo con buen drenaje,suelo rico en fosforo y potasio',2131165340)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Habichuela', '75 dias', '02/12/2022','Estable', 'Legumbre', 'Tropical', '20.5','90 %','20 semanas','2 vez/semana','N/A','50 cm', 'áfidos,chinches y ácaros de invernadero,antracnosis,mildiu pulverulento,podredumbre de raíces,marchitamiento,virosis','mucho riego,tierra siempre humeda,transplante segun vaya creciendo la planta,funjicidas de bajo impacto',2131165290)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Pimientos', '70 dias', '15/04/2022','Estable', 'Hortaliza', 'Tropical', '23','60 %','1 semanas','2 vez/semana','3 vez/mes','45 cm', 'araña blanca,araña roja,heliothis,mosca blanca,nematodos,meloidogyne,pulgones,rosquilla verde,trips','sustrato rico en materia organica,ubicacion de soportes para carga del peso,suficiente sol',2131165365)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Espinaca', '45 dias', '14/04/2022','Estable', 'Verdura', 'Templado', '17','97 %','2 semanas','3 vez/semana','N/A','25 cm', 'mildiu,cladosporium,alternaría,stemphylium,cercosporiosis','ubicacion en zona sombria,suficiente agua,suelo rico en materia organica',2131165286)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Lechuga', '65 dias', '23/11/2022','Estable', 'Hortaliza', 'Templado', '17','70 %','3 semanas','1 vez/semana','2 vez/mes','25 cm', 'virus de la vena ancha,virus del bronceado del tomate,virus de la mancha necrótica del impatiens,oídio,pudrición gris,mildiu','alta humedad,riego constante,suficiente luz natural',2131165318)");
            db.execSQL("insert into cultivo (NOMBRE,TIEMPOCOSECHA,FECHASIEMBRA,ESTADO,TIPOCULTIVO,CLIMA,TEMPERATURA,HUMEDAD,FRECUENCIAABONADO,FRECUENCIARIEGO,FRECUENCIAFUMIGACION,DISTANCIASEMILLAS,PLAGASENFERMEDADES,PREVENCIONCUIDADOS,IMAGEN) values ('Zanahoria', '60 dias', '30/03/2022','Estable', 'Hortaliza', 'Templado', '18','98 %','1 semanas','3 vez/semana','1 vez/mes','15 cm', 'enfermedades foliares por hongos,tizón de la hoja,oidio,oidiopsis,enfermedades de raíz por hongo,muerte de la raíz,pudrición en cráter,podredumbre blanca','riego constante,suelo rico en materia organica,climas templados o frios,tierra profunda,retirar hojas viejas',2131165376)");
            //insert cultivo_huerta
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(3,2)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(1,2)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(3,2)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(1,2)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(2,3)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(2,1)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(7,2)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(9,3)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(3,3)");
            db.execSQL("insert into CULTIVO_HUERTA (CULTIVOID,HUERTAID) values(6,2)");

            //db.execSQL("insert into HISTORIAL_NOTIFICACIONES (FECHA, TITULO, CONTENIDO) values('12/02/2010', 'HOLAAAAA', 'SEGUNDO INTENTO')");
        }

    }
}

