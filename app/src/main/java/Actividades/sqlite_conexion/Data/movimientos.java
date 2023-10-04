package Actividades.sqlite_conexion.Data;

import android.content.ContentValues;
import android.database.Cursor;
import Actividades.sqlite_conexion.Data.movimientosContract.MovimientosEntry;
public class movimientos {

    private String id_usuario;
    private String id_producto;
    private String accion;
    private String cantidad;

    public movimientos(String id, String nombre_prod, String descripcion, String cantidad_prod) {
        this.id_usuario = id;
        this.id_producto = nombre_prod;
        this.accion = descripcion;
        this.cantidad = cantidad_prod;
    }

    public movimientos(Cursor cursor){
        id_usuario = cursor.getInt(cursor.getColumnIndex(movimientosContract.MovimientosEntry.ID_PROD));
        id_producto =cursor.getInt(cursor.getColumnIndex(movimientosContract.MovimientosEntry.ID_USER));
        accion = cursor.getInt(cursor.getColumnIndex(movimientosContract.MovimientosEntry.ACTION));
        cantidad =cursor.getInt(cursor.getColumnIndex(movimientosContract.MovimientosEntry.QUANTITY));
    }

    public ContentValues toContentValues() {
        ContentValues Values =new ContentValues();
        Values.put(movimientosContract.MovimientosEntry.ID_PROD, id_usuario);
        Values.put(movimientosContract.MovimientosEntry.ID_USER, id_producto);
        Values.put(movimientosContract.MovimientosEntry.ACTION, accion);
        Values.put(movimientosContract.MovimientosEntry.QUANTITY, cantidad);
        return Values;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public String getId_producto() {
        return id_producto;
    }

    public String getAccion() {
        return accion;
    }

    public String getCantidad() {
        return cantidad;
    }

    }
