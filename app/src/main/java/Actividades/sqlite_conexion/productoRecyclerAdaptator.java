package Actividades.sqlite_conexion;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import Actividades.sqlite_conexion.Data.productos;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class productoRecyclerAdaptator extends RecyclerView.Adapter<productoRecyclerAdaptator.ViewHolder> {


    private Cursor cursorListaProductos;
    private OnItemClickListener listenerClick;

    public productoRecyclerAdaptator(OnItemClickListener listenerClick) {
        this.listenerClick = listenerClick;
    }

    interface OnItemClickListener{
        public void onClick(ViewHolder view, productos productoctualizado);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.fragment_plantilla_producto,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cursorListaProductos.moveToPosition(position);
        productos productoSeleccionado = new productos( cursorListaProductos );
        holder.productList.setText(productoSeleccionado.getNombre_prod().toString());
        holder.stockList.setText(Integer.toString(productoSeleccionado.getStock()));
        holder.valueList.setText(Float.toString(productoSeleccionado.getValor()));
    }

    @Override
    public int getItemCount() {
        if (cursorListaProductos!=null)
            return cursorListaProductos.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaProductos = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productList;
        TextView stockList;

        TextView valueList;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            productList = (TextView) itemView.findViewById( R.id.nombre_lista );
            stockList = (TextView) itemView.findViewById( R.id.stock_lista );
            valueList = (TextView) itemView.findViewById( R.id.valor_lista );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            productos productoActualizado = obtenerProducto( getAdapterPosition() );
            productoActualizado.setNombre_prod( "nada" );
            listenerClick.onClick( this,productoActualizado );
        }
    }

    private productos obtenerProducto(int posicion){
        if (cursorListaProductos!=null){
            cursorListaProductos.moveToPosition( posicion );
            productos nuevoUsuario = new productos( cursorListaProductos );
            return nuevoUsuario;
        }
        return null;
    }
}
