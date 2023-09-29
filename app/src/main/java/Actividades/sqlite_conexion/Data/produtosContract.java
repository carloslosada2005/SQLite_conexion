package Actividades.sqlite_conexion.Data;

import android.provider.BaseColumns;

public class produtosContract{

public static abstract class ProductoEntry implements BaseColumns {
    public static final String TABLE_NAME ="productos";
    public static final String ID = "id_prod";
    public static final String NAME = "nombre_prod";
    public static final String DESCRIPTION = "descripcion_prod";
    public static final String QUANTITY = "cantidad_prod";
    public static final String PRICE = "precio_prod";
}

}
