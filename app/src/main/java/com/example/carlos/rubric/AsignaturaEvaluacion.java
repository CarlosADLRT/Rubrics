package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by carlos on 17/04/17.
 */
@Table(database = AppDatabase.class)
public class AsignaturaEvaluacion extends BaseModel {
    @PrimaryKey
    String Evaluacion;
    @Column
    String Asignatura;

    public AsignaturaEvaluacion() {

    }

    public AsignaturaEvaluacion(String asignatura, String evaluacion) {
        Asignatura = asignatura;
        Evaluacion = evaluacion;
    }

    public String getEvaluacion() {
        return Evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        Evaluacion = evaluacion;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

    @Override
    public String toString() {
        return Evaluacion;
    }
}
