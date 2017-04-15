package com.example.carlos.rubric;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by antonio on 15/04/17.
 */
@Table(database = AppDatabase.class)
public class Rubric extends BaseModel{
    @PrimaryKey
    String Rubric;
    @Column
    String Asignatura;
    @Column
    int NCat;

    public Rubric() {

    }

    public int getNCat() {
        return NCat;
    }

    public void setNCat(int NCat) {
        this.NCat = NCat;
    }

    public String getRubric() {
        return Rubric;
    }

    public void setRubric(String rubric) {
        Rubric = rubric;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

}
