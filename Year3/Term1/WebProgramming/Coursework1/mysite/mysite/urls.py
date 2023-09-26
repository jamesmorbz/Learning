from django.urls import include, re_path
from django.contrib import admin

urlpatterns = [
    re_path(r'^polls/', include('polls.urls')),
    re_path(r'^admin/', admin.site.urls),
]
