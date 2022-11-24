package com.example.mymail.ui.inbox

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymail.Card
import com.example.mymail.Card_Adapter
import com.example.mymail.R
import com.example.mymail.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {

    private var _binding: FragmentInboxBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val inboxViewModel =
            ViewModelProvider(this).get(InboxViewModel::class.java)

        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val items = ArrayList<Card>()
        items.add(Card(R.mipmap.image1, "Card 1"))
        items.add(Card(R.mipmap.image2, "Card 2"))
        items.add(Card(R.mipmap.image3, "Card 3"))
        items.add(Card(R.mipmap.image4, "Card 4"))
        items.add(Card(R.mipmap.image5, "Card 5"))
        items.add(Card(R.mipmap.image6, "Card 6"))
        items.add(Card(R.mipmap.image7, "Card 7"))
        items.add(Card(R.mipmap.image8, "Card 8"))
        items.add(Card(R.mipmap.image9, "Card 9"))


        val recView = root.findViewById<RecyclerView>(R.id.recView)

        recView.setHasFixedSize(true)

        val adaptador = Card_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recView.itemAnimator = DefaultItemAnimator()

        adaptador.onClick = {
        }
        var modeCallBack: ActionMode.Callback = object : ActionMode.Callback {
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                val id = item?.itemId
                when (id) {
                    R.id.action_editar -> {
                        Log.i("MainActivity", "editar")
                        mode?.finish()
                    }
                    R.id.action_eliminar -> {
                        Log.i("MainActivity", "eliminar")
                        mode?.finish()
                    }
                    R.id.action_compartir -> {
                        Log.i("MainActivity", "compartir")
                        mode?.finish()
                    }
                    else -> return false
                }
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                var mode = mode
                mode = null
            }

            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                mode.setTitle("Options")
                mode.getMenuInflater().inflate(R.menu.menu_context, menu)
                return true
            }
        }

        adaptador.onLongClick = { view ->
            view.startActionMode(modeCallBack)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}