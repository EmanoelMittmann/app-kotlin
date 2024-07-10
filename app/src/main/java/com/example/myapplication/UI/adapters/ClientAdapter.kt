package com.example.myapplication.UI.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.domain.Client
import com.example.myapplication.databinding.ClientItemBinding
import java.util.UUID

class ClientAdapter(private val goDetails:(client: Client) -> Unit): RecyclerView.Adapter<ClientAdapter.ViewHolder>() {
    private lateinit var context: Context
    private lateinit var binding: ClientItemBinding
    private var listClient: List<Client> = emptyList();

    inner class ViewHolder(private val bindingHolder: ClientItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(client: Client) {
            bindingHolder.client = client
        }
    }

    fun setUpClients(data: List<Client>){
        print(data)
        this.listClient = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = ClientItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding);
    }

    override fun getItemCount(): Int {
        return listClient.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((listClient[position]))
        binding.executePendingBindings();

        holder.itemView.setOnClickListener{
            goDetails(listClient[position])
        }
    }
}