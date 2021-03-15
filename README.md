## RecyclerView封装

[![](https://jitpack.io/v/liangke21/myRecyclerView.svg)](https://jitpack.io/#liangke21/myRecyclerView)

### 将其添加到存储库末尾的root build.gradle中
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### 添加依赖项
```java
	dependencies {
	        implementation 'com.github.liangke21:myRecyclerView:Tag'
	}

```

## 添加接口

```
recfruit.adapter = RecyclerViewdapter(
            mList,
            object : RecyclerViewdapter.OnBMoreindDataListener<Datafruit> {
                override fun onBindViewHolder(
                    model: Datafruit,
                    viewHolder: CommonViewHolder,
                    type: Int,
                    position: Int
                ) {
                    when (model.type) {
                        typeTitle -> viewHolder.setText(R.id.Titlefruit, model.titlt)
                        typecontent -> {

                            viewHolder.setText(R.id.contentfruit, model.titlt)
                            viewHolder.setImage(R.id.icofruit, model.ico)

                            viewHolder.itemView.setOnClickListener {
                                //设置监听
                            }
                        }
                    }
                }

                override fun getLayoutId(type: Int): Int {

                    return if (type == typeTitle) {
                        R.layout.fruit_title
                    } else
                        R.layout.fruit_content


                }

                override fun getItemViewType(position: Int): Int {
                    return mList[position].type
                }
            })

```
## 效果图展示
<a title='' href='https://55-1251889734.cos.ap-beijing-1.myqcloud.com/SHqO17.png' >![](https://55-1251889734.cos.ap-beijing-1.myqcloud.com/SHqO17.png)</a>
<a title='' href='https://55-1251889734.cos.ap-beijing-1.myqcloud.com/hQrh0b.png' >![](https://55-1251889734.cos.ap-beijing-1.myqcloud.com/hQrh0b.png)</a>
