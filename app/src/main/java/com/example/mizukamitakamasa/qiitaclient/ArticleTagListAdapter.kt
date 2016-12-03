package com.example.mizukamitakamasa.qiitaclient

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import com.example.mizukamitakamasa.qiitaclient.model.ArticleTag
import com.example.mizukamitakamasa.qiitaclient.util.TagUtils
import com.example.mizukamitakamasa.qiitaclient.view.ArticleTagView

/**
 * Created by mizukamitakamasa on 2016/11/20.
 */
class ArticleTagListAdapter(private val context: Context) : BaseAdapter() {

  internal var articleTags = emptyArray<ArticleTag>()

  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View =
      ((convertView as? ArticleTagView) ?: ArticleTagView(context)).apply {
        setArticleTag(articleTags[position])
        val saveTags = TagUtils().loadName(context, "TAG")
        val checkBox = findViewById(R.id.tag_check_box) as CheckBox
        checkBox.isChecked = false
        for (tag in saveTags) {
          if (tag == articleTags[position].id) {
            checkBox.isChecked = true
          }
        }
      }

  override fun getItem(position: Int): Any? = articleTags[position]

  override fun getItemId(position: Int): Long = 0

  override fun getCount(): Int = articleTags.size

  fun addList(list: Array<ArticleTag>) {
    articleTags += list
  }
}