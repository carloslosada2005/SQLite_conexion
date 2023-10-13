package Actividades.sqlite_conexion.Data;

import android.content.ContentValues;
import android.database.Cursor;
import Actividades.sqlite_conexion.Data.movimientosContract.MovimientosEntry;
public class movimientos {

    private int id_usuario;
    private int id_producto;
    private int accion;
    private int cantidad;

    public movimientos(int id, int id_prod, int accion, int cantidad_prod) {
        this.id_usuario = id;
        this.id_producto = id_prod;
        this.accion = accion;
        this.cantidad = cantidad_prod;
    }

    public movimientos(Cursor cursor){
        id_usuario = cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ID_PROD));
        id_producto =cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ID_USER));
        accion = cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ACTION));
        cantidad =cursor.getInt(cursor.getColumnIndex(MovimientosEntry.QUANTITY));
    }

    public ContentValues toContentValues() {
        ContentValues Values =new ContentValues();
        Values.put(movimientosContract.MovimientosEntry.ID_PROD, id_usuario);
        Values.put(movimientosContract.MovimientosEntry.ID_USER, id_producto);
        Values.put(movimientosContract.MovimientosEntry.ACTION, accion);
        Values.put(movimientosContract.MovimientosEntry.QUANTITY, cantidad);
        return Values;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public int getAccion() {
        return accion;
    }

    public int getCantidad() {
        return cantidad;
    }

    }
