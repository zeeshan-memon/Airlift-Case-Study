package com.example.airliftcasestudy.ui.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.airliftcasestudy.R
import com.example.airliftcasestudy.data.model.response.BaseDataModel
import com.example.airliftcasestudy.ui.adapters.GalleryAdapter
import com.example.airliftcasestudy.data.remote.Status
import com.example.airliftcasestudy.data.remote.Resource
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


@Suppress("DEPRECATION")
class GalleryFragment : Fragment() {

    /**
     * Dependency injection of ViewModel, ViewModelFactory and repository.
     */
    @Inject
    lateinit var galleryViewModelFactory: GalleryViewModelFactory
    private lateinit var galleryViewModel: GalleryViewModel
    lateinit var galleryAdapter: GalleryAdapter
    lateinit var  rv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        rv = root.findViewById<RecyclerView>(R.id.rv_hits) as RecyclerView

        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        galleryViewModel =
            ViewModelProviders.of(this, galleryViewModelFactory)
                .get(GalleryViewModel::class.java)
        rv.layoutManager = GridLayoutManager(context, 2)
        val spacing = 50 // 50px
        rv.addItemDecoration(SpacesItemDecoration(spacing))
        context?.let { getData(it) }

    }

    /**
     * This method send api request to get all results and also observe api response.
     */
    private fun getData(context: Context) {

        val response = MutableLiveData<Resource<BaseDataModel>>()

        galleryViewModel.getData(response);

        response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.i("sjkKASJASKJKS", it.response.hits.toString())
                    galleryAdapter = GalleryAdapter(
                        context,
                        it.response.hits
                    ) { result ->

//                        val intent = Intent(baseContext, ViewResult::class.java)
//                        intent.putExtra("RESULT_NAME", result.name)
//                        intent.putExtra("RESULT_PRICE", result.price)
//                        intent.putExtra("RESULT_UID", result.uid)
//        //                        intent.putExtra("RESULT", "https://png.pngtree.com/thumb_back/fh260/background/20190223/ourmid/pngtree-pure-color-watercolor-graffiti-gradient-background-board-design-board-design-image_66713.jpg")
//                        startActivity(intent)

                    }

                    rv.adapter = galleryAdapter
                    galleryAdapter.notifyDataSetChanged()

                }
                Status.LOADING -> {
                    /**Can Use Loader**/
                    /**Can Use Loader**/
                }
                Status.ERROR -> {
                    /**
                    hideLoader
                    showErrorToast
                     **/
                    /**
                    hideLoader
                    showErrorToast
                     **/
                }
            }
        })
    }
}
