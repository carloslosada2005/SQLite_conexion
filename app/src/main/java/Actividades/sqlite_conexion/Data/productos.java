package Actividades.sqlite_conexion.Data;

import android.content.ContentValues;
import android.database.Cursor;
import Actividades.sqlite_conexion.Data.produtosContract.ProductoEntry;
public class productos {
    private String id;
    private String nombre_prod;
    private String descripcion;
    private String cantidad_prod;
    private String precio_ind;

    public productos(String id, String nombre_prod, String descripcion, String cantidad_prod, String precio_ind) {
        this.id = id;
        this.nombre_prod = nombre_prod;
        this.descripcion = descripcion;
        this.cantidad_prod = cantidad_prod;
        this.precio_ind = precio_ind;
    }

    public productos(Cursor cursor){
    id= cursor.getInt(cursor.getColumnIndex(ProductoEntry.ID));
    nombre_prod=cursor.getString(cursor.getColumnIndex(ProductoEntry.NAME));
    descripcion= cursor.getString(cursor.getColumnIndex(ProductoEntry.DESCRIPTION));
    cantidad_prod=cursor.getInt(cursor.getColumnIndex(ProductoEntry.QUANTITY));
    precio_ind=cursor.getFloat(cursor.getColumnIndex(ProductoEntry.PRICE));
    }

    public ContentValues toContentValues() {
        ContentValues Values =new ContentValues();
        Values.put(ProductoEntry.ID,id);
        Values.put(ProductoEntry.NAME,nombre_prod);
        Values.put(ProductoEntry.DESCRIPTION,descripcion);
        Values.put(ProductoEntry.QUANTITY,cantidad_prod);
        Values.put(ProductoEntry.PRICE,precio_ind);
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

    public String getCantidad_prod() {
        return cantidad_prod;
    }

    public String getPrecio_ind() {
        return precio_ind;
    }
}


