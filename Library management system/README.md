# 📚 نظام إدارة مكتبة الكلية

نظام بسيط تمت برمجته بلغة Java لإدارة مكتبة جامعية، يسمح بإدخال الكتب، البحث عنها، إنشاء استمارات استعارة، واستعراض جميع محتويات المكتبة. يعتمد على مصفوفة من الكائنات (مصفوفة سجلات) وواجهة تفاعلية نصيّة عبر سطر الأوامر.

---

## ✅ الميزات الأساسية

1. **إضافة كتاب جديد**
   - إدخال اسم الكتاب، رقم الكتاب، واسم المؤلف.
2. **البحث عن كتاب**
   - البحث يتم عن طريق اسم الكتاب وعرض تفاصيله في حال وجوده.
3. **استمارة استعارة كتاب**
   - تسجيل بيانات استعارة (رقم الكتاب، الرقم الأكاديمي للطالب، تاريخ الاستعارة).
4. **عرض جميع الكتب في المكتبة**
   - عرض قائمة منظمة بجميع الكتب المُضافة.
5. **قائمة خيارات تفاعلية**
   - تتيح للمستخدم الاختيار من 1 إلى 5، مع رسالة تنبيه عند إدخال رقم غير صحيح.

---

## 🛠️ الأدوات المستخدمة

- **لغة البرمجة**: Java  
- **بيئة التشغيل**: أي بيئة تدعم Java SE (مثل IntelliJ IDEA أو VS Code أو NetBeans)
- **أسلوب التنفيذ**: سطر أوامر (Console-based)

---

## 🚀 طريقة التشغيل

1. احفظ الكود في ملف باسم `LibrarySystem.java`.
2. افتح الطرفية (Terminal) وانتقل إلى مجلد الملف.
3. نفّذ الأوامر التالية:

   ```bash
   javac LibrarySystem.java
   java LibrarySystem