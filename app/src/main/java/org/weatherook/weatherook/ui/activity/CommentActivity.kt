package org.weatherook.weatherook.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_comment.*
import org.weatherook.weatherook.R
import org.weatherook.weatherook.adapter.recyclerview.CommentTotalAdapter
import org.weatherook.weatherook.api.network.NetworkService
import org.weatherook.weatherook.item.BoardCommentItem
import org.weatherook.weatherook.item.CommentTotalItem

class CommentActivity : AppCompatActivity() {

    val networkService by lazy {
        NetworkService.create()
    }
    var disposable: Disposable? = null

    lateinit var commenttotalItems: ArrayList<CommentTotalItem>
    lateinit var commenttotalAdapter : CommentTotalAdapter
    var boardIdx : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        commenttotalItems = ArrayList()
        //commenttotalItems = Gson().fromJson(intent.getStringExtra("comment"))
        commenttotalItems.clear()
        //commenttotalItems = fromJsonString(intent.getStringExtra("comment"))
        boardIdx = intent.getIntExtra("boardIdx",0)

        val call = networkService.getOneBoardComment(boardIdx)
        disposable = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        { GetCommentModel ->
                            Log.i("commendboard", GetCommentModel.data.size.toString())
                            for (i in 0..GetCommentModel.data.size-1){
                                GetCommentModel.data[i].let {
                                    commenttotalItems.add(CommentTotalItem(it.userImg,it.commentDate,it.commentId,it.commentDesc))
                                    commenttotalAdapter.notifyDataSetChanged()
                                }
                            }
                        }, {/* fail -> Log.i("urls_failed", fail.message) */})

        /*commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))
        commenttotalItems.add(CommentTotalItem(R.drawable.main_rain,"지금","13분전","우억"))


        commenttotalAdapter = CommentTotalAdapter(commenttotalItems, applicationContext)*/
        commenttotalAdapter = CommentTotalAdapter(commenttotalItems, applicationContext)
        comment_comment_recycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
        comment_comment_recycler.adapter = commenttotalAdapter

        reply_close.setOnClickListener{
            finish()
        }
//        reply_menu.setOnClickListener {
//            val view = LayoutInflater.from(applicationContext).inflate(R.layout.bottom_sheet, null)
//            val dialog = BottomSheetDialog(this)
//            dialog.setContentView(view)
//            dialog.show()
//        }
    }

    fun fromJsonString(s: String): ArrayList<BoardCommentItem> {
        return Gson().fromJson(s, object : TypeToken<ArrayList<BoardCommentItem>>() {}.type);
    }
}
