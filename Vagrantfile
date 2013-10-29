VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "drawing-wheezy64"
  config.vm.box_url = "http://dl.dropbox.com/u/937870/VMs/wheezy64.box"

  config.vm.provider :virtualbox do |vb|
     vb.customize ["modifyvm", :id, "--memory", "1024"]
  end

  config.vm.provision :shell, :path => "bootstrap.sh"
end
