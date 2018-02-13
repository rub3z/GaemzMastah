using GaemzMastah.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;

namespace GaemzMastah.ViewModel
{
    public class AppStructureViewModel: INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged = (sender, e) => { };

        public ObservableCollection<AppItem> GameList { get; set; }

        private ICommand command;
        public ICommand ClickCommand {
            get
            {
                return command ?? (command = new RelayCommand(p => RunApp(p)));
            }
        }

        public AppStructureViewModel()
        {
            GameList = new ObservableCollection<AppItem>(AppStructure.getApplicationItems());
        }

        private void RunApp(object s)
        {
            System.Diagnostics.Process pProcess=new System.Diagnostics.Process();
            //string s1 = "@" + "\""+s.ToString()+"\"";
           // MessageBox.Show(s1);
            pProcess.StartInfo.FileName = s.ToString();
            pProcess.Start();

        }


    }
}
