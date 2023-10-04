package Actividades.sqlite_conexion.Data;

import android.provider.BaseColumns;

public class movimientosContract{
    public static abstract class MovimientosEntry implements BaseColumns {

        public static final String TABLE_NAME ="productos";
        public static final String ID_PROD = "id_producto";
        public static final String ID_USER = "id_usuario";
        public static final String ACTION = "accion";
        public static final String QUANTITY = "cantidad";
    }
}
