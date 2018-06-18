# Non Swipe View Pager
A simple non swipeable view pager library for android

### Sdk Version ###
`compileSdkVersion` >= 25

### Importing to project ###

#### Example for Gradle: ####

Step 1. Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
		maven { url "https://maven.google.com" }
	}
}
```

##### If you're using gradle 3.+.+ 
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
		google()
	}
}
```

Step 2. Add the dependency
```groovy
implementation 'com.github.Johnyoat:non-swipe-view-pager:1.0.0'
```

Set 3. Using in XMl
```xml
 <com.litetech.libs.nonswipeviewpager.ViewPager
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/pager"/>
```

Step 4 . Example Usage in
```java
public class MainActivity extends AppCompatActivity {
    private int pg = 5;
    private  int st = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = findViewById(R.id.pager);
        AppCompatButton next = findViewById(R.id.next);
        List<Fragment> fragments = new ArrayList<>();

        for (int i = 1; i < 6 ; i++) {
            fragments.add(BlankFragment.newInstance(String.valueOf(i)));
        }

        pager.setAdapter(new ViewPagerAdapter(fragments,getSupportFragmentManager()));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (st < pg){
                    pager.setCurrentItem(st);
                    st++;
                }
            }
        });


    }
}
```

Step 5. Creating Adapter to handle
```java
    public class ViewPagerAdapter extends FragmentStatePagerAdapter{

        private List<Fragment> fragments;


        public ViewPagerAdapter(List<Fragment> fragments,FragmentManager fm) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
```



## Credits
[Library base on this stack overflow answer](https://stackoverflow.com/a/9650884/6736510)

## License

Copyright 2018 Litetech Ghana

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.