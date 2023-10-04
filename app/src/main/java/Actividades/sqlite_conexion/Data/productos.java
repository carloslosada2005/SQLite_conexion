package Actividades.sqlite_conexion.Data;

import android.content.ContentValues;
import android.database.Cursor;
import Actividades.sqlite_conexion.Data.movimientoContract.ProductosEntry;
public class productos {
    private String id;
    private String nombre_prod;
    private String descripcion;
    private String stock;
    private String valor;
    private String salidas;

    public productos(String id, String nombre_prod, String descripcion, String stock, String valor, String salidas) {
        this.id = id;
        this.nombre_prod = nombre_prod;
        this.descripcion = descripcion;
        this.stock = stock;
        this.valor = valor;
        this.salidas = salidas;
    }

    public productos(Cursor cursor){
    id= cursor.getInt(cursor.getColumnIndex(ProductosEntry.ID));
    nombre_prod=cursor.getString(cursor.getColumnIndex(ProductosEntry.NAME));
    descripcion= cursor.getString(cursor.getColumnIndex(ProductosEntry.DESCRIPTION));
    stock =cursor.getInt(cursor.getColumnIndex(ProductosEntry.QUANTITY));
    valor =cursor.getFloat(cursor.getColumnIndex(ProductosEntry.PRICE));
    salidas = cursor.getInt(cursor.getColumnIndex(ProductosEntry.OUT));
    }

    public ContentValues toContentValues() {
        ContentValues Values =new ContentValues();
        Values.put(ProductosEntry.ID,id);
        Values.put(ProductosEntry.NAME,nombre_prod);
        Values.put(ProductosEntry.DESCRIPTION,descripcion);
        Values.put(ProductosEntry.QUANTITY, stock);
        Values.put(ProductosEntry.PRICE, valor);
        Values.put(ProductosEntry.OUT, salidas);
        return Values;
    }

    public String getId() {
        return id;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getStock() {
        return stock;
    }

    public String getValor() {
        return valor;
    }

    public String getSalidas() {
        return salidas;
    }
}


