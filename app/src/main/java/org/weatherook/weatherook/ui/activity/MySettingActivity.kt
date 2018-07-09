package org.weatherook.weatherook.ui.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_my_setting.*
import org.weatherook.weatherook.R

class MySettingActivity : AppCompatActivity(), View.OnClickListener {

    private val REQ_CODE_SELECT_IMAGE = 100
   // private  var image : MultipartBody.Part? = null
    lateinit var data : Uri

    override fun onClick(p0: View?) {
        when(p0){
            my_setting_com_btn -> {
                finish()
                //일단
            }
            my_setting_change_profile -> {
                changeImage()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_setting)
        
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK)
                return
           /* {
                try {
                    //if(ApplicationController.getInstance().is)
                    this.data = data!!.data
                    Log.v("이미지", this.data.toString())

                    val options = BitmapFactory.Options()

                    var input: InputStream? = null // here, you need to get your context.
                    try {
                        input = contentResolver.openInputStream(this.data)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)
                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val photo = File(this.data.toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

                    ///RequestBody photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray());
                    // MultipartBody.Part 실제 파일의 이름을 보내기 위해 사용!!

                    image = MultipartBody.Part.createFormData("photo", photo.name, photoBody)

                    //body = MultipartBody.Part.createFormData("image", photo.getName(), profile_pic);

                    Glide.with(this)
                            .load(data.data)
                            .centerCrop()
                            .into(my_setting_profile_img)

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }*/
        }
    }


    fun changeImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent,REQ_CODE_SELECT_IMAGE) //실행한 엑티비티에서 받아옴
    }

    override fun onStart() {
        super.onStart()
        my_setting_change_profile.setOnClickListener(this)
    }

}
